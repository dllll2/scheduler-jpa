package com.example.schedulerjpa.dto;

import com.example.schedulerjpa.entity.Todo;
import lombok.Getter;

@Getter
public class TodoResponseDto {
    private final Long id;
    private final String title;
    private final String contents;

    public TodoResponseDto(Long id, String title, String contents) {
        this.id = id;
        this.title = title;
        this.contents = contents;
    }

    public static TodoResponseDto toDto(Todo todo){
        return new TodoResponseDto(todo.getId(), todo.getTitle(), todo.getContents());
    }
}
