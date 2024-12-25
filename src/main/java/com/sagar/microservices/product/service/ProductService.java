package com.sagar.microservices.product.service;

import com.sagar.microservices.product.dto.ProductRequest;
import com.sagar.microservices.product.model.Product;
import com.sagar.microservices.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public void createProduct(ProductRequest productRequest) {
        Product product = new Product();
        productRepository.save(product);
    }
}
