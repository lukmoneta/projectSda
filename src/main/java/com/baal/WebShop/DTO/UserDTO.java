package com.baal.WebShop.DTO;

import com.baal.WebShop.model.UserOrder;

import java.util.List;

public record UserDTO (Long id, String email, String phoneNumber, List<UserOrder> userOrderList, Long addressId){
}
