package com.sagar.microservices.product.mapper;

import com.sagar.microservices.product.dto.ProductRequestDto;
import com.sagar.microservices.product.dto.ProductResponseDto;
import com.sagar.microservices.product.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    /** The singleton instance of the ProductMapper. */
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    /**
     * Converts a Product entity to a ProductResponseDto.
     *
     * @param product The Product entity to be converted.
     * @return The converted ProductResponseDto.
     */
    ProductResponseDto productToDto(Product product);

    /**
     * Converts a ProductRequestDto to a Product entity.
     *
     * @param productRequestDto The ProductRequestDto to be converted.
     * @return The converted Product entity.
     */
    @Mapping(target = "id", ignore = true)
    Product dtoToProduct(ProductRequestDto productRequestDto);

    void dtoToProduct(ProductRequestDto productRequestDto, @MappingTarget Product product);

}
