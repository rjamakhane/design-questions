package com.scaler.splitexpense.commands;

import com.scaler.splitexpense.controllers.UserController;
import com.scaler.splitexpense.dto.CreateUserRequestDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@AllArgsConstructor
public class CreateUserCommand implements Command{

    private UserController userController;
    @Override
    public boolean matches(String input) {
        if(getCommand(input).equals(CommandKeys.REGISTER_USER_COMMAND)){
            return true;
        }
        return false;
    }

    @Override
    public void execute(String input) {
        //call user controller here
        List<String> tokens = getTokens(input);
        CreateUserRequestDTO request = CreateUserRequestDTO.builder()
                .name(tokens.get(1))
                .password(tokens.get(2))
                .email(tokens.get(3))
                .phoneNumber((tokens.get(4)))
                .build();
        userController.createUser(request);
    }
}
