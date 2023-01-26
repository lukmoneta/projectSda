package com.baal.WebShop.controller;

import com.baal.WebShop.DTO.AddressDTO;
import com.baal.WebShop.DTO.CreateAddressDTO;
import com.baal.WebShop.service.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/address")
public class AddressRestController {
    private final AddressService addressService;

    @PostMapping()
    public ResponseEntity<AddressDTO> createAddress(
            @Valid @RequestBody CreateAddressDTO createAddressDTO) {
        AddressDTO addressDTO = addressService.createAddress(createAddressDTO);
        return new ResponseEntity<>(addressDTO, HttpStatus.CREATED);

    }
}
