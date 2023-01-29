package com.baal.WebShop.repository.service;

import com.baal.WebShop.DTO.CreateOrderLineDTO;
import com.baal.WebShop.DTO.OrderLineDTO;
import com.baal.WebShop.DTO.OrderLineWithProductNameDTO;
import com.baal.WebShop.DTO.UpdateOrderlineDTO;
import jakarta.validation.Valid;

import java.util.List;

public interface OrderLineService {
    OrderLineDTO createOrderLine(@Valid CreateOrderLineDTO createOrderLineDTO);
    List<OrderLineDTO> getOrderLines();
    long numberOfOrderLines();

    List<OrderLineWithProductNameDTO> getOrderLinesWithProductNames();
   // void updateOrderLine(OrderLineWithProductNameDTO orderLineWithProductNameDTO);

    void updateOrderLine(List<OrderLineWithProductNameDTO> orderLineWithProductNameDTOList);
    void updateOrderQuantity(UpdateOrderlineDTO updateOrderlineDTO);
}
