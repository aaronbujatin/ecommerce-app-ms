package com.nozeryy.ecommerce.product;

import jakarta.validation.constraints.NotNull;

public record PurchaseRequest(
        @NotNull(message = "Product id is required")
        Integer productId,
        @NotNull(message = "Quantity is required")
        double quantity
        ) {
}
