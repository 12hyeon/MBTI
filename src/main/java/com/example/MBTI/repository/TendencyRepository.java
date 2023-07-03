package com.example.MBTI.repository;

import com.example.MBTI.entity.Tendency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TendencyRepository extends JpaRepository<Tendency, Long> {
    Tendency save(Tendency tendency);
    List<Tendency> findAll();

    List<Tendency> findAllByTypeId(Long type_id);

    @Query(value = "SELECT * FROM Tendency WHERE type_id = :type_id order by RAND() limit 1", nativeQuery = true)
    Optional<Tendency> findOne(@Param("type_id") Long type_id);
}
