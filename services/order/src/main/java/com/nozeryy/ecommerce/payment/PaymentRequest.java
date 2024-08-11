package com.nozeryy.ecommerce.payment;

import com.nozeryy.ecommerce.customer.CustomerResponse;
import com.nozeryy.ecommerce.order.PaymentMethod;

import java.math.BigDecimal;

public record PaymentRequest(
        BigDecimal amount,
        PaymentMethod paymentMethod,
        Integer orderId,
        String reference,
        CustomerResponse customer
) {
}
