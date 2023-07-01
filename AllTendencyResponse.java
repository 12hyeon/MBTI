package com.example.MBTI.response;

import com.example.MBTI.dto.AllTendencyDto;
import com.example.MBTI.exception.ExceptionCode;
import com.example.MBTI.exception.ResponseType;
import lombok.Getter;
import lombok.Setter;
import org.apache.catalina.connector.Response;

import java.util.List;

@Getter
@Setter
public class AllTendencyResponse extends ResponseType {

    private List<AllTendencyDto> data;

    public AllTendencyResponse(ExceptionCode exceptionCode, List<AllTendencyDto> data){
        super(exceptionCode);
        this.data = data;
    }
}
