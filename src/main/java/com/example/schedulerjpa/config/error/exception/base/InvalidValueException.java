package com.example.schedulerjpa.config.error.exception.base;


import com.example.schedulerjpa.config.error.ErrorCode;

public class InvalidValueException extends BusinessBaseException {

    public InvalidValueException(ErrorCode errorCode) {
        super(errorCode);
    }

    public InvalidValueException() {
        super(ErrorCode.INVALID_INPUT_VALUE);
    }
}
