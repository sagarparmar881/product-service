package com.sagar.microservices.product.response;

import io.swagger.v3.oas.annotations.media.Schema;
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
    @Schema(name = "message",
            example = "Operation successfull",
            description = "Description of API response")
    private String message;

    /** The body of the response, which can be any object. */
    @Schema(name = "body",
            example = "{\"name\": \"Lorem Ipsum Product\"}",
            description = "Description of API response")
    private Object body;
}
