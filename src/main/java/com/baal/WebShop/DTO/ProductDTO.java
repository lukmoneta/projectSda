package com.baal.WebShop.DTO;

import java.math.BigDecimal;

public record ProductDTO(Long id, String name, String description, String pictureUrl, BigDecimal price, Long categoryId){
}
