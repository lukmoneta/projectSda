package com.baal.WebShop.DTO;

import com.baal.WebShop.model.Product;

import java.math.BigDecimal;

public record OrderLineDTO(Long id, int numberOfProducts, BigDecimal valueOfProduct, Long productId) {
}
