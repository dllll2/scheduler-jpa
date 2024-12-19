package com.example.schedulerjpa.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;

@Getter
public class UpdatePasswordRequestDto {

    @NotEmpty(message = "수정할 비밀번호를 입력하세요")
    private final String oldPassword;

    @NotEmpty(message = "새로운 비밀번호를 입력하세요")
    private final String newPassword;

    public UpdatePasswordRequestDto(String oldPassword, String newPassword) {
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
    }
}
