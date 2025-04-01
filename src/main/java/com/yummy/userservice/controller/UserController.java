package com.yummy.userservice.controller;

import com.yummy.userservice.dto.UserDTO;
import com.yummy.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/fetchAllUsers")
    public ResponseEntity<List<UserDTO>> fetchAllUsers() {
        List<UserDTO> users = userService.findAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping("/addUser")
    public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDTO) {
        UserDTO savedUserDTO = userService.saveUserToDB(userDTO);
        return new ResponseEntity<>(savedUserDTO, HttpStatus.CREATED);
    }

}
