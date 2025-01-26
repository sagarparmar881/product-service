package com.sagar.microservices.product.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductNotFoundException extends ProductServiceException {

    /**
     * Exception thrown when a product is not found with the given identifier.
     *
     * @param input the identifier of the product that was not found
     */
    public ProductNotFoundException(final String input) {
        super("Product not found with id " + input);
    }
}
