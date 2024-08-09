package com.nozeryy.ecommerce.kafka;

import com.nozeryy.ecommerce.customer.CustomerResponse;
import com.nozeryy.ecommerce.order.PaymentMethod;
import com.nozeryy.ecommerce.product.PurchaseResponse;

import java.math.BigDecimal;
import java.util.List;

public record OrderConfirmation(
        String orderReference,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        CustomerResponse customer,
        List<PurchaseResponse> products

) {
}
