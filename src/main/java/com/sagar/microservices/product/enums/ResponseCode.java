package com.sagar.microservices.product.enums;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResponseCode {
    PRODUCT_DELETED("Product deleted successfully", HttpStatus.ACCEPTED);

    private final String message;
    private final HttpStatus httpStatus;
}
