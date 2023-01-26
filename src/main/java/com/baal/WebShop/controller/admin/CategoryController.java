package com.baal.WebShop.controller.admin;

import com.baal.WebShop.DTO.CategoryDTO;
import com.baal.WebShop.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("admin/category")
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping("")
    public String getCategories(Model model) {
        List<CategoryDTO> categories = categoryService.getCategories();
        model.addAttribute("categories",categories);
        return "admin/categoryList";
    }


}
