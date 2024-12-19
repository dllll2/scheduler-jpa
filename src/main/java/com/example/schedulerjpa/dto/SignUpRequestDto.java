package com.example.schedulerjpa.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;

@Getter
public class SignUpRequestDto {
    @NotEmpty(message = "이름을 반드시 입력하세요")
    private final String name;

    @NotEmpty(message = "비밀번호를 반드시 입력하세요")
    private final String password;

    @NotEmpty(message = "이메일을 반드시 입력하세요")
    @Email
    private final String email;

    public SignUpRequestDto(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
    }
}
