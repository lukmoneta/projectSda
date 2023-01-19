package com.baal.WebShop.service;

import com.baal.WebShop.DTO.AddressDTO;
import com.baal.WebShop.DTO.CreateAddressDTO;
import com.baal.WebShop.mapper.AddressModelMapper;
import com.baal.WebShop.model.Address;
import com.baal.WebShop.repository.AddressRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Validated
@Service
@RequiredArgsConstructor
public class AddressServiceImp implements AddressService {

    private final AddressRepository addressRepository;
    private final AddressModelMapper addressModelMapper;
    @Override
    public AddressDTO createAddress(@Valid CreateAddressDTO createAddressDTO) {
        Address address = Address.builder()
                .country(createAddressDTO.country())
                .city(createAddressDTO.city())
                .street(createAddressDTO.street())
                .postCode(createAddressDTO.postCode())
                .build();
        Address savedAddress = addressRepository.save(address);
        return addressModelMapper.mapAddressEntityToAddressDTO(savedAddress);
    }
}
