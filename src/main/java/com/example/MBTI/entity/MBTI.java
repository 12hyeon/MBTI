package com.example.MBTI.entity;

public enum MBTI {
    INFP(1), ENFP(2), INFJ(3), ENFJ(4),
    INTJ(5), ENTJ(6), INTP(7), ENTP(8),
    ISFP(9), ESFP(10), ISTP(11), ESTP(12),
    ISFJ(13), ESFJ(14), ISTJ(15), ESTJ(16);

    private final int number;

    MBTI(int number) {
        this.number = number;
    }
}