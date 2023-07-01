package com.example.MBTI.dto;

import com.example.MBTI.entity.Tendency;
import lombok.Getter;
import lombok.Setter;

@Getter
public class AllTendencyDto {
    private long id;
    private String mbti;
    private String info;
    private int count;

    public AllTendencyDto(Tendency tendency) {
        this.id = tendency.getId();
        this.mbti = tendency.getType().getMbti();
        this.info = tendency.getInfo();
        this.count = tendency.getCount();
    }
}