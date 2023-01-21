package com.baal.WebShop.service;

import com.baal.WebShop.DTO.CreateProductDTO;
import com.baal.WebShop.DTO.ProductDTO;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;

@Validated
public interface ProductService {
    ProductDTO createProduct (@Valid CreateProductDTO createProductDTO);
}
