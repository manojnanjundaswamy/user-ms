package com.yummy.userservice.service;

import com.yummy.userservice.dto.UserDTO;
import com.yummy.userservice.mapper.UserMapper;
import com.yummy.userservice.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public List<UserDTO> findAllUsers() {
        return userRepo.findAll().stream().map(user -> UserMapper.toUserDTO(user)).collect(Collectors.toList());
    }

    public UserDTO saveUserToDB(UserDTO userDTO) {
        return UserMapper.toUserDTO(userRepo.save(UserMapper.toUser(userDTO)));
    }
}
