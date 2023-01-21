package com.baal.WebShop.service;

import com.baal.WebShop.DTO.CreateUserDTO;
import com.baal.WebShop.DTO.UserDTO;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;

@Validated
public interface UserService {
    UserDTO createUser(@Valid CreateUserDTO createUserDTO);
}
