package com.example.MBTI.exception;

import lombok.Getter;

@Getter
public class ResponseType {
    private final Integer status;
    private final String message;

    public ResponseType(ExceptionCode exceptionCode) {
        this.status = exceptionCode.getStatus();
        this.message = exceptionCode.getMessage();
    }
}

