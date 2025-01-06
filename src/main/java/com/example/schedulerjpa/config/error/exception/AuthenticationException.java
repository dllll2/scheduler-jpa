package com.example.schedulerjpa.config.error.exception;


import com.example.schedulerjpa.config.error.ErrorCode;
import com.example.schedulerjpa.config.error.exception.base.BusinessBaseException;

public class AuthenticationException extends BusinessBaseException {

    public AuthenticationException(ErrorCode errorCode) {
        super(errorCode);
    }

    public AuthenticationException() {
        super(ErrorCode.AUTHENTICATION_FAILURE);
    }
}
