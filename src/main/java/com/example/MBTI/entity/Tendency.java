package com.example.MBTI.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "tendency")
public class Tendency {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "info")
    private String info;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="type_id")
    private Type type;

    private int count;

    @Builder
    public Tendency(Type type, String info) {
        this.type = type;
        this.info = info;
        this.count = 0;
    }

    public void addCount() {
        this.count += 1;
    }
}
