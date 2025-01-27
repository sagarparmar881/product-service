package com.sagar.microservices.product.controller;

import com.sagar.microservices.product.dto.ProductRequestDto;
import com.sagar.microservices.product.dto.ProductResponseDto;
import com.sagar.microservices.product.enums.ResponseCode;
import com.sagar.microservices.product.response.ApiResponse;
import com.sagar.microservices.product.response.ResponseHandler;
import com.sagar.microservices.product.service.ProductService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    /**
     * Deletes a product by id.
     * @param id product id
     * @return details of a deleted product
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteProduct(
            @PathVariable final String id) {
        return ResponseHandler.generateResponse(
                ResponseCode.PRODUCT_DELETED,
                productService.deleteProduct(id));
    }
}
