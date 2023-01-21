package com.baal.WebShop.DTO;

import com.baal.WebShop.model.OrderLine;
import com.baal.WebShop.model.User;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

public record UserOrderDTO(Long id, BigDecimal totalCost, Instant dateOfOrder, User userId, List<OrderLine> orderLineList) {
}
