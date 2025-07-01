package com.sagar.microservices.product.enums;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResponseCode {
    /** Product creation was successful. */
    PRODUCT_CREATED("Product created successfully", HttpStatus.CREATED),

    /** Single product retrieval was successful. */
    PRODUCT_RETRIEVED("Product retrieved successfully", HttpStatus.OK),

    /** All products retrieval was successful. */
    PRODUCTS_RETRIEVED("All Products retrieved successfully", HttpStatus.OK),

    /** Product deletion was successful. */
    PRODUCT_DELETED("Product deleted successfully", HttpStatus.ACCEPTED),

    /** Product update was successful. */
    PRODUCT_UPDATED("Product updated successfully", HttpStatus.OK);

    /** Descriptive message for the response */
    private final String message;

    /** Associated HTTP status for the response */
    private final HttpStatus httpStatus;
}
