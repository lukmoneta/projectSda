package com.baal.WebShop.service;

import com.baal.WebShop.DTO.CreateUserOrderDTO;
import com.baal.WebShop.DTO.UserOrderDTO;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
public interface UserOrderService {
    UserOrderDTO createUserOrder(@Valid CreateUserOrderDTO createUserOrderDTO);

    List<UserOrderDTO> getUserOrders();
}
