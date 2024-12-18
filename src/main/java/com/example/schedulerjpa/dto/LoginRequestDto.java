package com.example.schedulerjpa.dto;

import lombok.Getter;

@Getter
public class LoginRequestDto {
    private String email;
    private String password;

    public LoginRequestDto(String password, String email) {
        this.password = password;
        this.email = email;
    }
}
