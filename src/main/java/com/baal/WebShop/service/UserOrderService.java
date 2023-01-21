package com.baal.WebShop.service;

import com.baal.WebShop.DTO.CreateUserOrderDTO;
import com.baal.WebShop.DTO.UserOrderDTO;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;

@Validated
public interface UserOrderService {
    UserOrderDTO createUserOrder(@Valid CreateUserOrderDTO createUserOrderDTO);
}
