package com.baal.WebShop.service;

import com.baal.WebShop.DTO.CategoryDTO;
import com.baal.WebShop.DTO.CreateCategoryDTO;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;

@Validated
public interface CategoryService {

CategoryDTO createCategory(@Valid CreateCategoryDTO createCategoryDTO);
}
