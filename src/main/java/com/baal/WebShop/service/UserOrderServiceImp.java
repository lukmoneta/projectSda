package com.baal.WebShop.service;

import com.baal.WebShop.DTO.CreateUserOrderDTO;
import com.baal.WebShop.DTO.UserOrderDTO;
import com.baal.WebShop.mapper.UserOrderModelMapper;
import com.baal.WebShop.model.UserOrder;
import com.baal.WebShop.repository.UserOrderRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.time.Instant;

@Validated
@Service
@RequiredArgsConstructor
public class UserOrderServiceImp implements UserOrderService{
    private final UserOrderRepository userOrderRepository;
    private final UserOrderModelMapper userOrderModelMapper;
    @Override
    public UserOrderDTO createUserOrder(@Valid CreateUserOrderDTO createUserOrderDTO) {
        UserOrder userOrder = UserOrder.builder()
                .totalCost(createUserOrderDTO.totalCost())
                .dateOfOrder(Instant.now())
                .orderLineList(createUserOrderDTO.orderLineList())
                .user(createUserOrderDTO.userId())
                .build();
        UserOrder savedUserOrder = userOrderRepository.save(userOrder);
        return userOrderModelMapper.mapUserOrderEntityToUserOrderDTO(savedUserOrder);
    }
}
