package com.example.schedulerjpa.config.error.exception.base;


import com.example.schedulerjpa.config.error.ErrorCode;

public class AccessDeniedException extends BusinessBaseException {

    public AccessDeniedException(ErrorCode errorCode) {
        super(errorCode);
    }

    public AccessDeniedException() {
        super(ErrorCode.ACCESS_DENIED);
    }
}
