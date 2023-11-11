package com.scaler.splitexpense.commands;

import com.scaler.splitexpense.controllers.UserController;
import com.scaler.splitexpense.dto.CreateUserRequestDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SettleUp implements Command {

    @Override
    public boolean matches(String input) {

        return false;
    }

    @Override
    public void execute(String input) {

    }
}
