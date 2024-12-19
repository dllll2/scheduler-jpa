package com.example.schedulerjpa.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;

@Getter
public class CommentRequestDto {

    @NotEmpty(message = "댓글을 반드시 입력하세요")
    private final String contents;

    @NotEmpty(message = "이름을 반드시 입력하세요")
    private final String name;

    public CommentRequestDto(String contents, String name) {
        this.contents = contents;
        this.name = name;
    }
}
