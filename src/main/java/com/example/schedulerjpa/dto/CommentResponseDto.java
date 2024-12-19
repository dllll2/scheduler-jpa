package com.example.schedulerjpa.dto;

import lombok.Getter;

@Getter
public class CommentResponseDto {
    private final Long id;
    private final String contents;
    private final String name;
    private final Long todoId;

    public CommentResponseDto(Long id, String contents, String name, Long todoId) {
        this.id = id;
        this.contents = contents;
        this.name = name;
        this.todoId = todoId;
    }
}
