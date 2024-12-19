package com.example.schedulerjpa.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;

@Getter
public class UpdateContentRequestDto {

    @NotEmpty(message = "수정될 내용을 반드시 입력하세요")
    private final String oldContent;

    @NotEmpty(message = "새로운 내용을 반드시 입력하세요")
    private final String newContent;

    public UpdateContentRequestDto(String oldContent, String newContent) {
        this.oldContent = oldContent;
        this.newContent = newContent;
    }
}
