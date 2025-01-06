package com.example.schedulerjpa.config.error.exception.base;


import com.example.schedulerjpa.config.error.ErrorCode;

public class NotFoundException extends BusinessBaseException {

    public NotFoundException(ErrorCode errorCode) {
        super(errorCode);
    }

    public NotFoundException() {
        super(ErrorCode.NOT_FOUND);
    }
}
