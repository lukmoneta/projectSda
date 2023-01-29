package com.baal.WebShop.service;

import com.baal.WebShop.DTO.CreateProductDTO;
import com.baal.WebShop.DTO.ProductDTO;
import com.baal.WebShop.DTO.UpdateProductDTO;
import com.baal.WebShop.model.Product;

import java.util.List;


public interface ProductService {
    ProductDTO createProduct(CreateProductDTO createProductDTO);

    void deleteById(Long id);

    ProductDTO getProductById(Long id);

    ProductDTO updateProduct(UpdateProductDTO productDTO);

    List<ProductDTO> getProducts();

    Product getProductByName(String name);
}
