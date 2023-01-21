package com.baal.WebShop.DTO;

import java.math.BigDecimal;

public record CreateProductDTO(String name, String description, String pictureUrl, BigDecimal price, Long categoryId) {
}
