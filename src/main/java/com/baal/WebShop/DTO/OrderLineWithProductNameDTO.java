package com.baal.WebShop.DTO;

import java.math.BigDecimal;

public record OrderLineWithProductNameDTO(Long id,String productName, BigDecimal productPrice,int quantity, BigDecimal value) {
}
