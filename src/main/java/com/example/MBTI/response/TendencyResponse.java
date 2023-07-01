package com.example.MBTI.response;

import com.example.MBTI.exception.ExceptionCode;
import com.example.MBTI.exception.ResponseType;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TendencyResponse extends ResponseType {

    private String mbti;

    public TendencyResponse(ExceptionCode exceptionCode) {
        super(exceptionCode);
    }

    public TendencyResponse(ExceptionCode exceptionCode, String mbti) {
        super(exceptionCode);
        this.mbti = mbti;
    }

}
