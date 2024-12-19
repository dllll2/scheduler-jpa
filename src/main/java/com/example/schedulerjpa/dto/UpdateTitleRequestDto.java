package com.example.schedulerjpa.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;

@Getter
public class UpdateTitleRequestDto {

    @NotEmpty(message = "수정할 제목을 입력하세요")
    private final String oldTitle;

    @NotEmpty(message = "새로운 제목을 입력하세요")
    private final String newTitle;

    public UpdateTitleRequestDto(String oldTitle, String newTitle) {
        this.oldTitle = oldTitle;
        this.newTitle = newTitle;
    }
}
