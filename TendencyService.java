package com.example.MBTI.service;

import com.example.MBTI.dto.AllTendencyDto;
import com.example.MBTI.dto.TendencyDto;
import com.example.MBTI.entity.MBTI;
import com.example.MBTI.entity.Tendency;
import com.example.MBTI.entity.Type;
import com.example.MBTI.exception.ExceptionCode;
import com.example.MBTI.repository.TendencyRepository;
import com.example.MBTI.repository.TypeRepository;
import com.example.MBTI.response.AllTendencyResponse;
import com.example.MBTI.response.OneTendencyResponse;
import com.example.MBTI.response.TendencyResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Time;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.time.LocalDate.*;

@Service
@Transactional
@RequiredArgsConstructor
public class TendencyService {

    private final TypeRepository typeRepository;
    private final TendencyRepository tendencyRepository;

    public Object save(TendencyDto tendencyDto) {

        MBTI mbti;
        Type type;
        try {
            mbti = MBTI.valueOf(tendencyDto.getMbti().toUpperCase()); // try-catch
            type = typeRepository.findByMbti(mbti.name()).get();
        } catch(Exception e) {
            return new TendencyResponse(ExceptionCode.TYPE_NOT_FOUND);
        }

        Tendency tendency = Tendency.builder()
                .type(type)
                .info(tendencyDto.getInfo())
                .build();
        tendencyRepository.save(tendency);

        return new TendencyResponse(ExceptionCode.SUCCESS);
    }

    public Object findOne(String mbtiType) {
        MBTI mbti;
        Type type;
        try {
            mbti = MBTI.valueOf(mbtiType.toUpperCase());
        } catch(Exception e) {
            return new TendencyResponse(ExceptionCode.TYPE_NOT_FOUND);
        }

        type = typeRepository.findByMbti(mbti.name()).get();

        List<Tendency> tendency = tendencyRepository.findAllByTypeId(type.getId());
        if (tendency.size() == 0) {
            return new TendencyResponse(ExceptionCode.CONTEXT_NOT_FOUND, mbti.name());
        }

        int n = (int) Math.random()*tendency.size() -1; // 랜덤
        tendency.get(n).addCount(); // transaction
        return new OneTendencyResponse(ExceptionCode.SUCCESS, mbti, tendency.get(n));
    }

    public Object findAll() {
        List<Tendency> tendency = tendencyRepository.findAll();
        List<AllTendencyDto> response = new ArrayList<>();
        for (Tendency t : tendency) {
            response.add(new AllTendencyDto(t));
        }
        return new AllTendencyResponse(ExceptionCode.SUCCESS, response);
    }
}
