package com.baal.WebShop.repository.service;

import com.baal.WebShop.DTO.CreateUserDTO;
import com.baal.WebShop.DTO.UserDTO;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
public interface UserService {
    UserDTO createUser(@Valid CreateUserDTO createUserDTO);

    UserDTO getUserById(Long id);

    void deleteById(Long id);

    UserDTO updateUser(Long userId, UserDTO userDTO);

    List<UserDTO> getUsers();
}
