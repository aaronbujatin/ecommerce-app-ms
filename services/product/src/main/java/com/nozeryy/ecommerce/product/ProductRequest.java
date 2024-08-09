package com.nozeryy.ecommerce.product;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record ProductRequest(
        Integer id,
        @NotNull(message = "Product name is required")
        String name,
        @NotNull(message = "Product description is required")
        String description,
        @Positive(message = "Available quantity should positive")
        double availableQuantity,
        @Positive(message = "Price should positive")
        BigDecimal price,
        @NotNull(message = "Product category id is required ")
        Integer categoryId
) {
}
