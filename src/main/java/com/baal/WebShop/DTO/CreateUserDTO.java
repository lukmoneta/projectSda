package com.baal.WebShop.DTO;

import com.baal.WebShop.model.Address;
import com.baal.WebShop.model.UserOrder;

import java.util.List;

public record CreateUserDTO(String email, String phoneNumber, List<UserOrder> userOrderList, Address address) {
}
