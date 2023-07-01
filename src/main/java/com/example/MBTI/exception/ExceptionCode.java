package com.example.MBTI.exception;

import com.example.MBTI.entity.MBTI;
import lombok.Getter;

public enum ExceptionCode {
    TYPE_NOT_FOUND(404, "MBTI Type Not Found"),
    CONTEXT_NOT_FOUND(201, "MBTI Tendency Not Found"),
    SUCCESS(200, "Success");

    @Getter
    private int status;

    @Getter
    private String message;

    ExceptionCode(int status, String message) {
        this.status = status;
        this.message = message;
    }
}