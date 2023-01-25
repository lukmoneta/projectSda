package com.baal.WebShop.service;

import com.baal.WebShop.DTO.CreateProductDTO;
import com.baal.WebShop.DTO.ProductDTO;
import com.baal.WebShop.mapper.ProductModelMapper;
import com.baal.WebShop.model.Category;
import com.baal.WebShop.model.Product;
import com.baal.WebShop.repository.CategoryRepository;
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
    private final CategoryRepository categoryRepository;
    private final ProductModelMapper productModelMapper;

    @Override
    public ProductDTO createProduct(CreateProductDTO createProductDTO) {
        Category category = categoryRepository.findById(createProductDTO.categoryId()).orElseThrow(()->new RuntimeException("No category ID"));
        Product product = Product.builder()
                .name(createProductDTO.name())
                .description(createProductDTO.description())
                .pictureUrl(createProductDTO.pictureUrl())
                .price(createProductDTO.price())
                .category(category)
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
                .orElseThrow(() -> new RuntimeException(String.format("product with %d doesnt exist", id)));
    }

    @Override
    public ProductDTO updateProduct(ProductDTO productDTO) {

        Product product = productRepository.findById(productDTO.id())
                .orElseThrow(() -> new RuntimeException(String.format("product with %d doesnt exist", productDTO.id())));
        Category category = categoryRepository.findById(productDTO.categoryId())
                .orElseThrow(() -> new RuntimeException(String.format("product with %d doesnt exist", productDTO.categoryId())));

        product.setCategory(category);
        product.setDescription(productDTO.description());
        product.setName(productDTO.name());
        product.setPictureUrl(productDTO.pictureUrl());
        product.setPrice(productDTO.price());

        Product savedEditedProduct = productRepository.save(product);
        return productModelMapper.mapProductEntityToProductDTO(savedEditedProduct);
    }

    public List<ProductDTO> getProducts() {
        List<Product> list = productRepository.findAll();
        return list.stream().map(productModelMapper::mapProductEntityToProductDTO).toList();
    }
}
