package com.example.schedulerjpa.config.error.exception;


import com.example.schedulerjpa.config.error.ErrorCode;
import com.example.schedulerjpa.config.error.exception.base.NotFoundException;

public class CommentNotFoundException extends NotFoundException {

    public CommentNotFoundException(ErrorCode commentNotFound) {
        super(ErrorCode.COMMENT_NOT_FOUND);
    }
}
