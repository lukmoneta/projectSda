package com.baal.WebShop.mapper;

import com.baal.WebShop.DTO.AddressDTO;
import com.baal.WebShop.model.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressModelMapper {

    AddressDTO mapAddressEntityToAddressDTO (Address address);
}
