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

import java.util.List;
import java.util.Optional;

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

    @Override
    public CategoryDTO findById(Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        return category.map(categoryModelMapper::mapCategoryEntityToCategoryDTO)
                .orElseThrow(()-> new RuntimeException(String.format("Category with id: %d not found",id)));
    }

    @Override
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public List<CategoryDTO> getCategories() {
        List<Category> list = categoryRepository.findAll();
        return list.stream().map(categoryModelMapper::mapCategoryEntityToCategoryDTO).toList();
    }

    @Override
    public CategoryDTO updateCategory(Long categoryId, CategoryDTO categoryDTO) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException(String.format("category with &d doesnt exist", categoryId)));
        category.setName(categoryDTO.name());

        Category savedEditedCategory = categoryRepository.save(category);
        return categoryModelMapper.mapCategoryEntityToCategoryDTO(savedEditedCategory);
    }
}
