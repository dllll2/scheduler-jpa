package com.example.schedulerjpa.service;

import com.example.schedulerjpa.config.error.ErrorCode;
import com.example.schedulerjpa.config.error.exception.CommentNotFoundException;
import com.example.schedulerjpa.dto.CommentRequestDto;
import com.example.schedulerjpa.dto.CommentResponseDto;
import com.example.schedulerjpa.entity.Comment;
import com.example.schedulerjpa.entity.Member;
import com.example.schedulerjpa.entity.Todo;
import com.example.schedulerjpa.repository.CommentRepository;
import com.example.schedulerjpa.repository.MemberRepository;
import com.example.schedulerjpa.repository.TodoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final MemberRepository memberRepository;
    private final TodoRepository todoRepository;

    public CommentResponseDto save(Long todoId, CommentRequestDto requestDto) {
        Member member = memberRepository.findMemberByNameOrElseThrow(requestDto.getName());
        Todo todo = todoRepository.findByIdOrElseThrow(todoId);

        Comment comment = new Comment(requestDto.getContents(), member, todo);
        Comment savedComment = commentRepository.save(comment);

        return new CommentResponseDto(
                savedComment.getId(),
                savedComment.getContents(),
                member.getName(),
                todo.getId()
        );
    }

    @Transactional
    public List<CommentResponseDto> findAllByTodoId(Long todoId) {
        return commentRepository.findAll()
                .stream()
                .filter(comment -> comment.getTodo().getId().equals(todoId))
                .map(comment -> new CommentResponseDto(
                        comment.getId(),
                        comment.getContents(),
                        comment.getMember().getName(),
                        comment.getTodo().getId()
                ))
                .collect(Collectors.toList());
    }

    public CommentResponseDto update(Long commentId, CommentRequestDto requestDto) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new CommentNotFoundException(ErrorCode.COMMENT_NOT_FOUND));
        comment.update(requestDto.getContents());

        return new CommentResponseDto(
                comment.getId(),
                comment.getContents(),
                comment.getMember().getName(),
                comment.getTodo().getId()
        );
    }

    public void delete(Long commentId) {
        commentRepository.deleteById(commentId);
    }
}
