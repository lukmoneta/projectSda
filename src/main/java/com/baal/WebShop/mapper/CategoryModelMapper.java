package com.baal.WebShop.mapper;

import com.baal.WebShop.DTO.CategoryDTO;
import com.baal.WebShop.model.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryModelMapper {
CategoryDTO mapCategoryEntityToCategoryDTO(Category category);
}
