package com.example.schedulerjpa.dto;

import java.time.LocalDateTime;

public interface TodoPageResponseDto {
    Long getId();
    String getTitle();
    String getContents();
    String getMemberName();
    int getCommentCount();
    LocalDateTime getCreatedAt();
    LocalDateTime getUpdatedAt();
}
