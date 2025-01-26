package com.sagar.microservices.product.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.util.List;

public record ProductRequestDto(

        @NotBlank(message = "Product name cannot be blank")
        @Size(
                max = 128,
                message = "Product name must not exceed 128 characters")
        String name,
        String description,
        BigDecimal price,
        List<String> images) {
}
