package com.baal.WebShop.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

public record ProductDTO(Long id, String name, String description, String pictureUrl, BigDecimal price, Long categoryId){

    public ProductDTO() {
        this(null,null,null,null,null,null);
    }
}
