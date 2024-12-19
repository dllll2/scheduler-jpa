package com.example.schedulerjpa.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequestDto {

    @NotEmpty(message = "이메일을 반드시 입력하세요")
    @Email
    private String email;

    @NotEmpty(message = "비밀번호를 반드시 입력하세요")
    private String password;

    public LoginRequestDto(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
