package com.example.schedulerjpa.dto;

import lombok.Getter;

@Getter
public class LoginResponseDto {
    private Long memberId;
    private String email;
    private String message;

    public LoginResponseDto(Long memberId, String email, String message) {
        this.memberId = memberId;
        this.email = email;
        this.message = message;
    }
}
