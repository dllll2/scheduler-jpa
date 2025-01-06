package com.example.schedulerjpa.config.error.exception.base;


import com.example.schedulerjpa.config.error.ErrorCode;

public class ConflictException extends BusinessBaseException {

    public ConflictException(ErrorCode errorCode) {
        super(errorCode);
    }

    public ConflictException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }
}
