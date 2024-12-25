package com.sagar.microservices.product.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document(value = "product")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Product {

    /**
     * The unique identifier for the product.
     */
    private String id;

    /**
     * The name of the product.
     */
    private String name;

    /**
     * A brief description of the product.
     */
    private String description;

    /**
     * The price of the product.
     */
    private BigDecimal price;
}
