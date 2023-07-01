package com.example.MBTI.repository;

import com.example.MBTI.entity.MBTI;
import com.example.MBTI.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TypeRepository extends JpaRepository<Type, Long> {
    Type save(Type type);
    Optional<Type> findByMbti(String mbti);
    long count();
    List<Type> findAll();
}
