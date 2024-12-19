package com.example.schedulerjpa.controller;

import com.example.schedulerjpa.dto.CommentRequestDto;
import com.example.schedulerjpa.dto.CommentResponseDto;
import com.example.schedulerjpa.service.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/todos/{todoId}/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    public ResponseEntity<CommentResponseDto> save(
            @PathVariable Long todoId,
            @Validated @RequestBody CommentRequestDto requestDto) {
        CommentResponseDto responseDto = commentService.save(todoId, requestDto);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CommentResponseDto>> getAll(@PathVariable Long todoId) {
        List<CommentResponseDto> comments = commentService.findAllByTodoId(todoId);
        return ResponseEntity.ok(comments);
    }

    @PutMapping("/{commentId}")
    public ResponseEntity<CommentResponseDto> update(
            @PathVariable Long commentId,
            @Validated @RequestBody CommentRequestDto requestDto) {
        CommentResponseDto responseDto = commentService.update(commentId, requestDto);
        return ResponseEntity.ok(responseDto);
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<Void> delete(@PathVariable Long commentId) {
        commentService.delete(commentId);
        return ResponseEntity.noContent().build();
    }
}
