package com.baal.WebShop.controller.admin;

import com.baal.WebShop.DTO.ProductDTO;
import com.baal.WebShop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
@RequiredArgsConstructor
@Controller
public class HomeAdminController {
    private final ProductService productService;
    @GetMapping("/admin")
    public String getHome(Model model) {
        List<ProductDTO> productList = productService.getProducts();
        model.addAttribute("products", productList);
        return "admin/index";
    }
}
