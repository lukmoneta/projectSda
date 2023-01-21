package com.baal.WebShop.service;

import com.baal.WebShop.DTO.AddressDTO;
import com.baal.WebShop.DTO.CreateAddressDTO;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;

@Validated
public interface AddressService {
    AddressDTO createAddress(@Valid CreateAddressDTO createAddressDTO);
}
