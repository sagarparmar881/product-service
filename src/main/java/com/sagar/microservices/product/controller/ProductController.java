package com.sagar.microservices.product.controller;

import com.sagar.microservices.product.dto.ProductRequestDto;
import com.sagar.microservices.product.enums.ResponseCode;
import com.sagar.microservices.product.response.ApiResponse;
import com.sagar.microservices.product.response.ProductServiceResponse;
import com.sagar.microservices.product.service.ProductService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
@Tag(name = "Products")
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
    @Operation(
            summary = "Create a new product",
            description = "This endpoint creates a new product using the provided product details."
    )
    public ResponseEntity<ApiResponse> createProduct(
            @Valid @RequestBody final ProductRequestDto productRequestDto) {
        return ProductServiceResponse.build(
                ResponseCode.PRODUCT_RETRIEVED,
                productService.createProduct(productRequestDto));
    }

    /**
     * Retrieves all products.
     * @param page the page number for pagination
     * @param size the size of elements on page
     * @return a list of all products
     */
    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    @Operation(
            summary = "Get all products",
            description = "This endpoint retrieves all products."
    )
    public ResponseEntity<ApiResponse> getAllProducts(
            @RequestParam(defaultValue = "0") final int page,
            @RequestParam(defaultValue = "10") final int size
    ) {
        return ProductServiceResponse.build(
                ResponseCode.PRODUCT_RETRIEVED,
                productService.getAllProducts(page, size));
    }

    /**
     * Retrieves a product by id.
     * @param id product id
     * @return details of a product
     */
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(
            summary = "Get a product by ID",
            description = "Retrieves the details of a specific product based on the provided ID."
    )
    public ResponseEntity<ApiResponse> getProduct(
            @PathVariable final String id) {
        return ProductServiceResponse.build(
                ResponseCode.PRODUCT_RETRIEVED,
                productService.getProduct(id));
    }

    /**
     * Partially updates a product by id.
     * @param id product id
     * @param productRequestDto the product details to update
     * @return the updated product
     */
    @PatchMapping("/{id}")
    @Operation(
            summary = "Partially update a product by ID",
            description = "Partially updates the details of a specific product based on the provided ID."
    )
    public ResponseEntity<ApiResponse> updateProduct(
            @PathVariable final String id,
            @Valid @RequestBody final ProductRequestDto productRequestDto) {
        return ProductServiceResponse.build(
                ResponseCode.PRODUCT_UPDATED,
                productService.updateProduct(id, productRequestDto));
    }

    /**
     * Deletes a product by id.
     * @param id product id
     * @return details of a deleted product
     */
    @DeleteMapping("/{id}")
    @Operation(
            summary = "Delete a product by ID",
            description = "Deletes a specific product based on the provided ID.x"
    )
    public ResponseEntity<ApiResponse> deleteProduct(
            @PathVariable final String id) {
        return ProductServiceResponse.build(
                ResponseCode.PRODUCT_DELETED,
                productService.deleteProduct(id));
    }
}
