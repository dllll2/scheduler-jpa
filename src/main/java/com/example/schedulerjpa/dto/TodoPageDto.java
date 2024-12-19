package com.example.schedulerjpa.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TodoPageDto {
    private Long id;            // 할일 ID
    private String title;       // 할일 제목
    private String contents;    // 할일 내용
    private String name;        // 작성자 이름
    private Long commentCount;  // 댓글 개수
}
