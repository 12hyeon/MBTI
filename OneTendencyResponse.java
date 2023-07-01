package com.example.MBTI.response;

import com.example.MBTI.dto.AllTendencyDto;
import com.example.MBTI.entity.MBTI;
import com.example.MBTI.entity.Tendency;
import com.example.MBTI.exception.ExceptionCode;
import com.example.MBTI.exception.ResponseType;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OneTendencyResponse extends ResponseType {

    private MBTI mbti;
    private String info;
    private int count;


    public OneTendencyResponse(ExceptionCode exceptionCode, MBTI mbti, Tendency tendency) {
        super(exceptionCode);
        this.mbti = mbti;
        this.info = tendency.getInfo();
        this.count = tendency.getCount();
    }

}
