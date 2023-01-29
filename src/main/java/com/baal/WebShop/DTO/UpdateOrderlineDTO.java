package com.baal.WebShop.DTO;

import java.math.BigDecimal;

public record UpdateOrderlineDTO(Long id, Integer quantity, BigDecimal productPrice,BigDecimal value) {
}
