package com.example.schedulerjpa.dto;

import lombok.Getter;

@Getter
public class TodoWithNameResponseDto {
    private final String title;
    private final String contents;
    private final String name;

    public TodoWithNameResponseDto(String title, String contents, String name) {
        this.title = title;
        this.contents = contents;
        this.name = name;
    }
}
