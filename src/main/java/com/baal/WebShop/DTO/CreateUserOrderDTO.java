package com.baal.WebShop.DTO;

import com.baal.WebShop.model.OrderLine;
import com.baal.WebShop.model.User;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

public record CreateUserOrderDTO(BigDecimal totalCost, User userId, List<OrderLine> orderLineList) {
}
