package com.baal.WebShop.DTO;

import java.math.BigDecimal;

public record GivenUpdateOrdeLineDTO(Long id, Integer quantity, BigDecimal productPrice, BigDecimal value) {
}
