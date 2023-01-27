package com.baal.WebShop.mapper;

import com.baal.WebShop.DTO.OrderLineDTO;
import com.baal.WebShop.model.OrderLine;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderLineModelMapper {
    OrderLineDTO mapOrderLineEntityToOrderLineDTO (OrderLine orderLine);
}
