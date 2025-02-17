package com.example.schedulerjpa.config.error;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {

    // Basic
    INVALID_INPUT_VALUE(HttpStatus.BAD_REQUEST, "E1", "올바르지 않은 입력값입니다."),
    METHOD_NOT_ALLOWED(HttpStatus.METHOD_NOT_ALLOWED, "E2", "잘못된 HTTP 메서드를 호출했습니다."),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "E3", "서버에 에러가 발생했습니다."),
    NOT_FOUND(HttpStatus.NOT_FOUND, "E4", "존재하지 않는 엔티티입니다."),
    CONFLICT(HttpStatus.CONFLICT, "E5", "이미 존재하는 엔티티입니다."),
    ACCESS_DENIED(HttpStatus.FORBIDDEN, "E6", "접근 권한이 없습니다."),

    // MEMBER
    MEMBER_NOT_FOUND(HttpStatus.NOT_FOUND, "M4", "존재하지 않는 유저입니다."),
    MEMBER_CONFLICT(HttpStatus.CONFLICT, "M5", "이미 존재하는 유저입니다."),
    AUTHENTICATION_FAILURE(HttpStatus.UNAUTHORIZED, "M6", "비밀번호가 일치하지 않습니다."),

    // Todo
    TODO_NOT_FOUND(HttpStatus.NOT_FOUND, "T4", "존재하지 않는 게시글입니다."),
    TODO_ACCESS_DENIED(HttpStatus.FORBIDDEN, "T6", "사용자가 이 게시글에 접근할 권한이 없습니다."),
    TODO_ALREADY_DELETED(HttpStatus.CONFLICT, "T7", "이미 삭제된 게시글 입니다."),
    TODO_ALREADY_RESTORED(HttpStatus.CONFLICT, "T8", "이미 복구된 게시글입니다."),
    TITLE_ALREADY_EXISTS(HttpStatus.BAD_REQUEST,"T9","수정된 제목이 기존 제목과 동일합니다."),
    CONTENT_ALREADY_EXISTS(HttpStatus.BAD_REQUEST,"T10","수정된 내용이 기존 내용과 동일합니다."),

    // Comment
    COMMENT_NOT_FOUND(HttpStatus.NOT_FOUND, "C4", "존재하지 않는 댓글입니다."),
    COMMENT_ACCESS_DENIED(HttpStatus.FORBIDDEN, "C6", "해당 댓글에 대한 접근 권한이 없습니다."),

    ;

    private final HttpStatus status;
    private final String message;
    private final String code;

    ErrorCode(final HttpStatus status, String code, final String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }
}
