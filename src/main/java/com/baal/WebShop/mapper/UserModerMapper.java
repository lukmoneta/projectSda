package com.baal.WebShop.mapper;

import com.baal.WebShop.DTO.UserDTO;
import com.baal.WebShop.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserModerMapper {
    UserDTO mapUserEntityToUserDTO (User user);
}
