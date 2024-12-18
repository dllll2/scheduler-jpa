package com.example.schedulerjpa.dto;

import lombok.Getter;

@Getter
public class UpdateContentRequestDto {
    private final String oldContent;
    private final String newContent;

    public UpdateContentRequestDto(String oldContent, String newContent) {
        this.oldContent = oldContent;
        this.newContent = newContent;
    }
}
