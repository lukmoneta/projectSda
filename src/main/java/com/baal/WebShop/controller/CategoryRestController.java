package com.baal.WebShop.controller;

import com.baal.WebShop.DTO.CategoryDTO;
import com.baal.WebShop.DTO.CreateCategoryDTO;
import com.baal.WebShop.service.CategoryService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("admin/category")
public class CategoryRestController {
    private final CategoryService categoryService;

    @PostMapping()
    public ResponseEntity<CategoryDTO> createCategory(
            @Valid @RequestBody CreateCategoryDTO createCategoryDTO) {
        CategoryDTO categoryDTO = categoryService.createCategory(createCategoryDTO);
        return new ResponseEntity<>(categoryDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> findCategoryById(@Min(1) @NotNull @PathVariable Long id) {
        CategoryDTO categoryDTO = categoryService.findById(id);
        return new ResponseEntity<>(categoryDTO, HttpStatus.OK);
    }
}
