package com.sagar.microservices.product.service;

import com.sagar.microservices.product.dto.ProductRequest;
import com.sagar.microservices.product.model.Product;
import com.sagar.microservices.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    /**
     * This is for product repository.
     */
    private final ProductRepository productRepository;

    /**
     * Creates a new product based on the provided product request.
     *
     * @param productRequest the request containing product details
     * @return the newly created product
     */
    public Product createProduct(final ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.name())
                .price(productRequest.price())
                .description(productRequest.description())
                .build();
        productRepository.save(product);
        return product;
    }

    /**
     * Retrieves a list of all products from the repository.
     *
     * @return a list of all products
     */
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
