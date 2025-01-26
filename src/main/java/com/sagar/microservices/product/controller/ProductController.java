package com.sagar.microservices.product.controller;

import com.sagar.microservices.product.dto.ProductRequestDto;
import com.sagar.microservices.product.dto.ProductResponseDto;
import com.sagar.microservices.product.service.ProductService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PathVariable;

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
     * @param productRequestDto the product details to create
     * @return the created product
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponseDto createProduct(
            @Valid @RequestBody final ProductRequestDto productRequestDto) {
        return productService.createProduct(productRequestDto);
    }

    /**
     * Retrieves all products.
     *
     * @return a list of all products
     */
    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponseDto> getAllProducts() {
        return productService.getAllProducts();
    }

    /**
     * Retrieves a product by id.
     * @param id product id
     * @return details of a product
     */
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductResponseDto getProduct(@PathVariable final String id) {
        return productService.getProduct(id);
    }
}
