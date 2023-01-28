package com.baal.WebShop.mapper;

import com.baal.WebShop.DTO.ProductDTO;
import com.baal.WebShop.model.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductModelMapper {

    ProductDTO mapProductEntityToProductDTO(Product product);
}
