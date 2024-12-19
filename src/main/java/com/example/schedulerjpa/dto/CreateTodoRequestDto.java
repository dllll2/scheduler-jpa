package com.example.schedulerjpa.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;

@Getter
public class CreateTodoRequestDto {

    @NotEmpty(message = "제목을 반드시 입력하세요")
    private final String title;

    @NotEmpty(message = "내용을 반드시 입력하세요")
    private final String contents;

    @NotEmpty(message = "이름을 반드시 입력하세요")
    private final String name;

    public CreateTodoRequestDto(String title, String contents, String name) {
        this.title = title;
        this.contents = contents;
        this.name = name;
    }
}
