package com.yummy.userservice.mapper;

import com.yummy.userservice.dto.UserDTO;
import com.yummy.userservice.entity.User;

public class UserMapper {

    public static UserDTO toUserDTO(User user) {
        if (user == null) {
            return null;
        }
        return new UserDTO(
            user.getId(),
            user.getUserName(),
            user.getUserPassword(),
            user.getAddress(),
            user.getCity()
        );
    }

    public static User toUser(UserDTO userDTO) {
        if (userDTO == null) {
            return null;
        }
        return new User(
            userDTO.getId(),
            userDTO.getUserName(),
            userDTO.getUserPassword(),
            userDTO.getAddress(),
            userDTO.getCity()
        );
    }
}