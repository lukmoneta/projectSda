package com.baal.WebShop.repository.service;

import com.baal.WebShop.DTO.CreateProductDTO;
import com.baal.WebShop.DTO.ProductDTO;
import com.baal.WebShop.DTO.UpdateProductDTO;
import java.util.List;


public interface ProductService {
    ProductDTO createProduct(CreateProductDTO createProductDTO);

    void deleteById(Long id);

    ProductDTO getProductById(Long id);

    ProductDTO updateProduct(UpdateProductDTO productDTO);

    List<ProductDTO> getProducts();
}
