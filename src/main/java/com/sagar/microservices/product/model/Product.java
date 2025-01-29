package com.sagar.microservices.product.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.List;

@Document(value = "product")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Product {

    /**
     * The unique identifier for the product.
     */
    @Schema(name = "Product ID")
    private String id;

    /**
     * The name of the product.
     */
    @Schema(name = "Product Name")
    private String name;

    /**
     * A brief description of the product.
     */
    @Schema(name = "Product Description")
    private String description;

    /**
     * The price of the product.
     */
    @Schema(name = "Product Price")
    private BigDecimal price;

    /**
     * The images of the product.
     */
    @Schema(name = "Product Images")
    private List<String> images;
}
