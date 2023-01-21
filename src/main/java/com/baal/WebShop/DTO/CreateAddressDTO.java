package com.baal.WebShop.DTO;

public record CreateAddressDTO(String country, String city, String street, String postCode, Long userId) {
}
