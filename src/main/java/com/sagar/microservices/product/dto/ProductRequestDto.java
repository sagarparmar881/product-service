package com.sagar.microservices.product.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.util.List;

public record ProductRequestDto(

        @NotBlank(message = "Product name cannot be blank")
        @Size(
                max = 128,
                message = "Product name must not exceed 128 characters")
        @Schema(
                name = "name",
                example = "iPhone13",
                description = "Product Name")
        String name,

        @Schema(name = "description",
                example = "iPhone 13 Black, 128 GB Variant",
                description = "Product Description")
        String description,

        @Schema(name = "price",
                example = "700.99",
                description = "Product Price")
        BigDecimal price,

        @Schema(name = "images",
                example =
                        "[\"https://example.com/image1.jpg\"," +
                        "\"https://example.com/image2.jpg\"]",
                description = "Product Images",
        type = "array")
        List<String> images) {
}
