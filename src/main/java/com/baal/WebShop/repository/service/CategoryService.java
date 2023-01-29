package com.baal.WebShop.repository.service;

import com.baal.WebShop.DTO.CategoryDTO;
import com.baal.WebShop.DTO.CreateCategoryDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
public interface CategoryService {

CategoryDTO createCategory(@Valid CreateCategoryDTO createCategoryDTO);
CategoryDTO findById(@NotNull @Min(1) Long id);
void deleteById(Long id);

List<CategoryDTO> getCategories();

CategoryDTO updateCategory(Long categoryId, CategoryDTO categoryDTO);
}
