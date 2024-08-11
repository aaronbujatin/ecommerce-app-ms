package com.nozeryy.ecommerce.order;

import com.nozeryy.ecommerce.customer.CustomerClient;
import com.nozeryy.ecommerce.exception.BusinessException;
import com.nozeryy.ecommerce.kafka.OrderConfirmation;
import com.nozeryy.ecommerce.kafka.OrderProducer;
import com.nozeryy.ecommerce.orderline.OrderLineRequest;
import com.nozeryy.ecommerce.orderline.OrderLineService;
import com.nozeryy.ecommerce.payment.PaymentClient;
import com.nozeryy.ecommerce.payment.PaymentRequest;
import com.nozeryy.ecommerce.product.ProductClient;
import com.nozeryy.ecommerce.product.PurchaseRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final CustomerClient customerClient;
    private final ProductClient productClient;
    private final OrderMapper orderMapper;
    private final OrderLineService orderLineService;
    private final OrderProducer orderProducer;
    private final PaymentClient paymentClient;

    public Integer createOrder(OrderRequest orderRequest) {
        var customer = customerClient.findCustomerById(orderRequest.customerId())
                .orElseThrow(() -> new BusinessException("Cannot create order. No Customer exists with id " + orderRequest.customerId()));
       var purchasedProducts = productClient.purchaseProducts(orderRequest.products());

       var order = orderRepository.save(orderMapper.toOrder(orderRequest));

       for(PurchaseRequest purchaseRequest : orderRequest.products()){
            orderLineService.saveOrderLine(
                    new OrderLineRequest(
                            null,
                            order.getId(),
                            purchaseRequest.productId(),
                            purchaseRequest.quantity()
                    )
            );
       }

       var paymentRequest = new PaymentRequest(
               orderRequest.amount(),
               orderRequest.paymentMethod(),
               order.getId(),
               order.getReference(),
               customer
       );
       paymentClient.requestOrderPayment(paymentRequest);

       orderProducer.sendOrderConfirmation(
               new OrderConfirmation(
                       orderRequest.reference(),
                       orderRequest.amount(),
                       orderRequest.paymentMethod(),
                       customer,
                       purchasedProducts
               )
       );
        return order.getId();
    }

    public List<OrderResponse> findAllOrder() {
    return orderRepository.findAll()
                .stream()
                .map(orderMapper::fromOrder)
                .toList();
    }

    public OrderResponse findOrderById(Integer orderId) {
        return orderRepository.findById(orderId)
                .map(orderMapper::fromOrder)
                .orElseThrow(() -> new BusinessException("Order not found with id " + orderId));
    }
}
