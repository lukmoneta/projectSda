package com.baal.WebShop.mapper;

import com.baal.WebShop.DTO.UserOrderDTO;
import com.baal.WebShop.model.UserOrder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserOrderModelMapper {
    UserOrderDTO mapUserOrderEntityToUserOrderDTO (UserOrder userOrder);
}
