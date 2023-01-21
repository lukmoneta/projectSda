package com.baal.WebShop.service;

import com.baal.WebShop.DTO.CreateProductDTO;
import com.baal.WebShop.DTO.ProductDTO;
import com.baal.WebShop.mapper.ProductModelMapper;
import com.baal.WebShop.model.Product;
import com.baal.WebShop.repository.ProductRepository;
import jakarta.validation.Valid;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Validated
@Service
@RequiredArgsConstructor
public class ProductServiceImp implements ProductService {
    private final ProductRepository productRepository;
    private final ProductModelMapper productModelMapper;
    @Override
    public ProductDTO createProduct(@Valid CreateProductDTO createProductDTO) {
        Product product = Product.builder()
                .name(createProductDTO.name())
                .description(createProductDTO.description())
                .pictureUrl(createProductDTO.pictureUrl())
                .price(createProductDTO.price())
                .build();
        Product savedProduct = productRepository.save(product);
        return productModelMapper.mapProductEntityToProductDTO(savedProduct);
    }
}
