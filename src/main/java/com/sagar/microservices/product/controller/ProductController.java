package com.sagar.microservices.product.controller;

import com.sagar.microservices.product.dto.ProductRequest;
import com.sagar.microservices.product.model.Product;
import com.sagar.microservices.product.service.ProductService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    /**
     * This is for product service.
     */
    private final ProductService productService;

    /**
     * Creates a new product.
     *
     * @param productRequest the product details to create
     * @return the created product
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product createProduct(
            @RequestBody final ProductRequest productRequest) {
        return productService.createProduct(productRequest);
    }

    /**
     * Retrieves all products.
     *
     * @return a list of all products
     */
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }
}
