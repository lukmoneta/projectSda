package com.baal.WebShop.mapper;

import com.baal.WebShop.DTO.ProductDTO;
import com.baal.WebShop.model.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class ProductMapper implements ProductModelMapper{
    @Override
    public ProductDTO mapProductEntityToProductDTO(Product product) {

        return new ProductDTO(

                product.getId(), product.getName(), product.getDescription(), product.getPictureUrl(),
                product.getPrice(),product.getCategory().getId());

    }

}
