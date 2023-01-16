package com.baal.WebShop.service;

import com.baal.WebShop.DTO.CategoryDTO;
import com.baal.WebShop.DTO.CreateCategoryDTO;
import com.baal.WebShop.mapper.CategoryModelMapper;
import com.baal.WebShop.model.Category;
import com.baal.WebShop.repository.CategoryRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Validated
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryModelMapper categoryModelMapper;

    @Override
    public CategoryDTO createCategory(@Valid CreateCategoryDTO createCategoryDTO) {

        Category category = new Category();
        category.setName(createCategoryDTO.name());
        Category savedCategory = categoryRepository.save(category);
        return categoryModelMapper.mapCategoryEntityToCategoryDTO(savedCategory);
    }
}
