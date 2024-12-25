package com.sagar.microservices.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductServiceApplication {

    /**
     * The main entry point for the Product Service application.
     * Initializes and starts the Spring Boot application.
     *
     * @param args command-line arguments
     */
    public static void main(final String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }
}
