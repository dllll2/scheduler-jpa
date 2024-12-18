package com.example.schedulerjpa.dto;

import lombok.Getter;

@Getter
public class UpdateTitleRequestDto {
    private final String oldTitle;
    private final String newTitle;

    public UpdateTitleRequestDto(String oldTitle, String newTitle) {
        this.oldTitle = oldTitle;
        this.newTitle = newTitle;
    }
}
