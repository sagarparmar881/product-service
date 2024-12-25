package com.sagar.microservices.product.mapper;

import com.sagar.microservices.product.dto.ProductRequestDto;
import com.sagar.microservices.product.dto.ProductResponseDto;
import com.sagar.microservices.product.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductResponseDto productToDto(Product product);

    @Mapping(target = "id", ignore = true)
    Product dtoToProduct(ProductRequestDto productRequestDto);
}
