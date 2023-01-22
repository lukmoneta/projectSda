package com.baal.WebShop.service;

import com.baal.WebShop.DTO.CreateProductDTO;
import com.baal.WebShop.DTO.ProductDTO;
import com.baal.WebShop.mapper.ProductModelMapper;
import com.baal.WebShop.model.Product;
import com.baal.WebShop.repository.ProductRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

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

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public ProductDTO getProductById(Long id) {
        return productRepository.findById(id).map(productModelMapper::mapProductEntityToProductDTO)
                .orElseThrow(()-> new RuntimeException(String.format("product with %d doesnt exist", id)));
    }

    public List<ProductDTO> getProducts() {
        List<Product> list = productRepository.findAll();
        return list.stream().map(productModelMapper::mapProductEntityToProductDTO).toList();
    }
}
