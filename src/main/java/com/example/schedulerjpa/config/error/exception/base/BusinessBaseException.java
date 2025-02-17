package com.example.schedulerjpa.config.error.exception.base;

import com.example.schedulerjpa.config.error.ErrorCode;
import lombok.Getter;

@Getter
public class BusinessBaseException extends RuntimeException {

    private final ErrorCode errorCode;

    public BusinessBaseException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public BusinessBaseException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}
