package com.baal.WebShop.repository.service;

import com.baal.WebShop.DTO.AddressDTO;
import com.baal.WebShop.DTO.CreateAddressDTO;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;

@Validated
public interface AddressService {
    AddressDTO createAddress(@Valid CreateAddressDTO createAddressDTO);

    AddressDTO updateAddress(Long addressId, AddressDTO addressDTO);

    AddressDTO findById (Long id);
}
