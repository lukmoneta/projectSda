package com.baal.WebShop.controller.thymeleaf;

import com.baal.WebShop.DTO.ProductDTO;
import com.baal.WebShop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequiredArgsConstructor
@Controller
 @RequestMapping("admin/products")
public class ProductController {
    private final ProductService productService;

    @GetMapping("")
    public String productList(Model model) {
        List<ProductDTO> productList = productService.getProducts();
        model.addAttribute("products", productList);
        return "admin/index";
    }
        @GetMapping("delete")
    public String deleteProduct(@RequestParam Long id){
        productService.deleteById(id);
        return "redirect:/admin/products";
    }
}
