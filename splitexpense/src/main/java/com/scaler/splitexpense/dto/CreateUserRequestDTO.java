package com.scaler.splitexpense.dto;

import com.scaler.splitexpense.models.User;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateUserRequestDTO {
    private String name;
    private String email;
    private String password;
    private String phoneNumber;

    public User toUser(){
        return User.builder()
                .name(name)
                .phoneNumber(phoneNumber)
                .email(email)
                .password(password)
                .build();
    }
}
