package com.baal.WebShop.service;

import com.baal.WebShop.DTO.CreateProductDTO;
import com.baal.WebShop.DTO.ProductDTO;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
public interface ProductService {
    ProductDTO createProduct(@Valid CreateProductDTO createProductDTO);
    void deleteById(Long id);
    ProductDTO getProductById(Long id);

    List<ProductDTO> getProducts();
}
