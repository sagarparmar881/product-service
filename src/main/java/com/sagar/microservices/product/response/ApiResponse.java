package com.sagar.microservices.product.response;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.Getter;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class ApiResponse {
    /** The message accompanying the response. */
    private String message;

    /** The body of the response, which can be any object. */
    private Object body;
}
