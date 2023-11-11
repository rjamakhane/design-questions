package com.scaler.splitexpense.controllers;

import com.scaler.splitexpense.dto.CreateUserRequestDTO;
import com.scaler.splitexpense.models.User;
import com.scaler.splitexpense.repository.UserRepository;
import com.scaler.splitexpense.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class UserController {

    private UserService userService;

    public User createUser(CreateUserRequestDTO user){
        return userService.createUser(user.toUser());
    }
}
