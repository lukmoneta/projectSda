package com.baal.WebShop.DTO;

import java.math.BigDecimal;

public record CreateOrderLineDTO(int numberOfProducts, BigDecimal valueOfProduct, Long productId) {
}
