package com.baal.WebShop.controller.admin;

import com.baal.WebShop.DTO.CategoryDTO;
import com.baal.WebShop.DTO.CreateCategoryDTO;
import com.baal.WebShop.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/add")
    public String addCategory(Model model) {
        model.addAttribute("createCategory", new CreateCategoryDTO(null));
        model.addAttribute("categories", categoryService.getCategories());
        return "admin/addCategory";
    }

    @PostMapping(value = "/add")
    public String addNewCategory(@ModelAttribute CreateCategoryDTO createCategoryDTO) {
        categoryService.createCategory(createCategoryDTO);
        return "redirect:/admin/category";
    }

    @GetMapping("/delete")
    public String deleteCategoryById(@RequestParam Long id){
        categoryService.deleteById(id);
        return "redirect:/admin/category";
    }



}
