package com.example.MBTI.test;

import com.example.MBTI.entity.MBTI;
import com.example.MBTI.entity.Type;
import com.example.MBTI.repository.TypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class dataRunner implements ApplicationRunner {

    private final TypeRepository typeRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (typeRepository.count() == 0) {
            for (MBTI m : MBTI.values()) {
                Type type = Type.builder().mbti(m.name()).build();
                typeRepository.save(type);
            }
        }

    }
}
