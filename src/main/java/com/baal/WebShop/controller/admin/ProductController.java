package com.baal.WebShop.controller.admin;

import com.baal.WebShop.DTO.CreateProductDTO;
import com.baal.WebShop.DTO.ProductDTO;
import com.baal.WebShop.DTO.UpdateProductDTO;
import com.baal.WebShop.repository.service.CategoryService;
import com.baal.WebShop.repository.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("admin/products")
public class ProductController {
    private final ProductService productService;
    private final CategoryService categoryService;

    @GetMapping("")
    public String productList(Model model) {
        List<ProductDTO> productList = productService.getProducts();
        model.addAttribute("products", productList);
        return "admin/productList";
    }

    @GetMapping("delete")
    public String deleteProduct(@RequestParam Long id) {
        productService.deleteById(id);
        return "redirect:/admin/products";
    }

    @GetMapping("/edit")
    public String editProduct(@RequestParam long id, Model model, Model model1) {
        ProductDTO productDTO = productService.getProductById(id);
        model.addAttribute("updateProduct", productDTO);
        model1.addAttribute("categories", categoryService.getCategories());
        return "admin/editProduct";
    }

    @PostMapping("/edit")
    public String editOldProduct(@ModelAttribute UpdateProductDTO updateProductDTO) {
        productService.updateProduct(updateProductDTO);
        return "redirect:/admin/products";
    }

    @GetMapping("/add")
    public String addProduct(Model model) {
        model.addAttribute("createproduct", new ProductDTO());
        model.addAttribute("categories", categoryService.getCategories());
        return "admin/addProduct";
    }

    @PostMapping(value = "/add")
    public String addNewProduct(@ModelAttribute CreateProductDTO createProductDTO) {
        productService.createProduct(createProductDTO);
        return "redirect:/admin/products";
    }

}
