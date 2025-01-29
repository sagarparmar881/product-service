package com.sagar.microservices.product.dto;

import java.math.BigDecimal;
import java.util.List;

public record ProductResponseDto(
        String id,
        String name,
        String description,
        BigDecimal price,
        List<String> images) {
}
