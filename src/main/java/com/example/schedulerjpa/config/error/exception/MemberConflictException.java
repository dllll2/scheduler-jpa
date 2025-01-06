package com.example.schedulerjpa.config.error.exception;


import com.example.schedulerjpa.config.error.ErrorCode;
import com.example.schedulerjpa.config.error.exception.base.ConflictException;

public class MemberConflictException extends ConflictException {

    public MemberConflictException() {
        super(ErrorCode.MEMBER_CONFLICT);
    }

}
