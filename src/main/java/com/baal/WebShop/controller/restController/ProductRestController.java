package com.baal.WebShop.controller.restController;

import com.baal.WebShop.DTO.ProductDTO;
import com.baal.WebShop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductRestController {
    private final ProductService productService;

    @GetMapping("")
    public ResponseEntity<List<ProductDTO>> getProducts() {

        List<ProductDTO> products = productService.getProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

}
