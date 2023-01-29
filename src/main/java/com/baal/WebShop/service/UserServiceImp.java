package com.baal.WebShop.service;

import com.baal.WebShop.DTO.CreateUserDTO;
import com.baal.WebShop.DTO.UserDTO;
import com.baal.WebShop.mapper.UserModerMapper;
import com.baal.WebShop.model.Address;
import com.baal.WebShop.model.User;
import com.baal.WebShop.repository.AddressRepository;
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
    private final AddressRepository addressRepository;
    private final UserRepository userRepository;
    private final UserModerMapper userModerMapper;

    @Override
    public UserDTO createUser(@Valid CreateUserDTO createUserDTO) {
        User user = User.builder()
                .email(createUserDTO.email())
                .phoneNumber(createUserDTO.phoneNumber())
                .address(createUserDTO.address())
                .build();
        User saveUser = userRepository.save(user);
        return userModerMapper.mapUserEntityToUserDTO(saveUser);
    }

    @Override
    public UserDTO getUserById(Long id) {
        return userRepository.findById(id).map(userModerMapper::mapUserEntityToUserDTO)
                .orElseThrow(() -> new RuntimeException(String.format("user with %d doesnt exist",id)));
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDTO updateUser(Long userId, UserDTO userDTO) {
        Address address = addressRepository.findById(userDTO.addressId())
                .orElseThrow(()-> new RuntimeException((String.format("address with %d doesnt exist", userDTO.addressId()))));
        User user = userRepository.findById(userId)
                .orElseThrow(()-> new RuntimeException(String.format("user with %d doesent exist", userId)));
        user.setAddress(address);
        user.setEmail(userDTO.email());
        user.setPhoneNumber(userDTO.phoneNumber());
        User savedEditedUser = userRepository.save(user);
        return userModerMapper.mapUserEntityToUserDTO(savedEditedUser);
    }

    @Override
    public List<UserDTO> getUsers() {
        List<User> list = userRepository.findAll();
        return list.stream().map(userModerMapper::mapUserEntityToUserDTO).toList();
    }
}
