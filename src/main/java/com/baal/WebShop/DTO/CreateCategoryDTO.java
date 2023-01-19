package com.baal.WebShop.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record CreateCategoryDTO(@NotBlank @Size(max = 20) @Pattern(regexp = "[\\w ]+") String name) {

}
