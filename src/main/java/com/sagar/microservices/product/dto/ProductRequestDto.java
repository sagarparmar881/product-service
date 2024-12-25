package com.sagar.microservices.product.dto;

import java.math.BigDecimal;

public record ProductRequestDto(
        String name,
        String description,
        BigDecimal price) {
}
