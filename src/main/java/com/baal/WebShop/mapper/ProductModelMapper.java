package com.baal.WebShop.mapper;

import com.baal.WebShop.DTO.ProductDTO;
import com.baal.WebShop.model.CreateProductDto;
import com.baal.WebShop.model.Product;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface ProductModelMapper {

    ProductDTO mapProductEntityToProductDTO(Product product);
}
