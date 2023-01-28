package com.baal.WebShop.DTO;

import java.math.BigDecimal;

public record OrderLineWithProductNameDTO(String productName, int quantity, BigDecimal value) {
}
