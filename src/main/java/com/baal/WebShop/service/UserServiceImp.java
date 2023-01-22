package com.baal.WebShop.service;

import com.baal.WebShop.DTO.CreateUserDTO;
import com.baal.WebShop.DTO.UserDTO;
import com.baal.WebShop.mapper.UserModerMapper;
import com.baal.WebShop.model.User;
import com.baal.WebShop.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {
    private final UserRepository userRepository;
    private final UserModerMapper userModerMapper;

    @Override
    public UserDTO createUser(@Valid CreateUserDTO createUserDTO) {
        User user = User.builder()
                .email(createUserDTO.email())
                .phoneNumber(createUserDTO.phoneNumber())
                .address(createUserDTO.address())
                .build();
        return null;
    }

    @Override
    public List<UserDTO> getUsers() {
        List<User> list = userRepository.findAll();
        return list.stream().map(userModerMapper::mapUserEntityToUserDTO).toList();
    }
}
