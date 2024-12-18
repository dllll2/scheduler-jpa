package com.example.schedulerjpa.dto;

import lombok.Getter;

@Getter
public class SignUpRequestDto {
    private final String name;

    private final String password;

    private final String email;

    public SignUpRequestDto(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
    }
}
