package com.baal.WebShop.service;

import com.baal.WebShop.DTO.CreateOrderLineDTO;
import com.baal.WebShop.DTO.OrderLineDTO;
import jakarta.validation.Valid;

import java.util.List;

public interface OrderLineService {
    OrderLineDTO createOrderLine(@Valid CreateOrderLineDTO createOrderLineDTO);
    List<OrderLineDTO> getOrderLines();
    long numberOfOrderLines();
}
