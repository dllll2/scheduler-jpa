package com.example.schedulerjpa.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponseDto {
    private Long id;
    private String email;
    private String message;

    public LoginResponseDto(Long id, String email, String message) {
        this.id = id;
        this.email = email;
        this.message = message;
    }
}
