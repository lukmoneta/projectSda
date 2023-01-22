package com.baal.WebShop.controller.thymeleaf;

import com.baal.WebShop.DTO.ProductDTO;
import com.baal.WebShop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class ProductController {
    private final ProductService productService;

    @GetMapping("admin/products")
    public String productList(Model model) {
        List<ProductDTO> productList = productService.getProducts();
        model.addAttribute("products", productList);
        return "admin/index";

    }
}
