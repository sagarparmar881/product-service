package com.sagar.microservices.product.service;

import com.sagar.microservices.product.dto.ProductRequestDto;
import com.sagar.microservices.product.dto.ProductResponseDto;
import com.sagar.microservices.product.exception.ProductNotFoundException;
import com.sagar.microservices.product.mapper.ProductMapper;
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
     * This is for product mapper.
     */
    private final ProductMapper productMapper;

    /**
     * Creates a new product based on the provided product request.
     *
     * @param productRequestDto the request containing product details
     * @return the newly created product
     */
    public ProductResponseDto createProduct(
            final ProductRequestDto productRequestDto) {
        var productDto = this.productMapper.dtoToProduct(productRequestDto);
        var savedProduct = productRepository.save(productDto);
        return this.productMapper.productToDto(savedProduct);
    }

    /**
     * Retrieves a products from the inner method.
     *
     * @return details of a product
     * @param id if of a product
     */
    public ProductResponseDto getProduct(final String id) {
        var product = this.findProductById(id);
        return this.productMapper.productToDto(product);
    }

    /**
     * Retrieves a product from the repository by its id.
     *
     * @return details of a product by id
     * @param id if of a product
     */
    private Product findProductById(final String id) {
        var product = productRepository.findById(id);
        return product.orElseThrow(() -> new ProductNotFoundException(id));
    }

    /**
     * Retrieves a list of all products from the inner method.
     *
     * @return a list of all products dto
     */
    public List<ProductResponseDto> getAllProducts() {
        var allProducts = this.findAllProducts();
        return allProducts.stream().map(productMapper::productToDto).toList();
    }

    /**
     * Retrieves a list of all products from the repository.
     *
     * @return a list of all products
     */
    private List<Product> findAllProducts() {
        var products = productRepository.findAll();
        if (products.isEmpty()) {
            throw new ProductNotFoundException();
        }
        return products;
    }

    /**
     * Partially updates a product based on its id.
     *
     * @param id                  the id of the product
     * @param productRequestDto   the product details to update
     * @return the updated product
     */
    public ProductResponseDto updateProduct(final String id, final ProductRequestDto productRequestDto) {
        var product = this.findProductById(id);

        // This will update the product entity with the DTO fields
        productMapper.dtoToProduct(productRequestDto, product);

        // Save and return the updated product
        var updatedProduct = productRepository.save(product);
        return this.productMapper.productToDto(updatedProduct);
    }

    /**
     * Deletes a product based on id.
     *
     * @return a details of deleted product
     * @param id if of a product
     */
    public ProductResponseDto deleteProduct(final String id) {
        var product = this.findProductById(id);
        this.deleteProductById(product.getId());
        return this.productMapper.productToDto(product);
    }

    private void deleteProductById(final String id) {
        productRepository.deleteById(id);
    }
}
