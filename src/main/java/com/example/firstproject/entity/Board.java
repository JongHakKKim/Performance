package com.example.firstproject.entity;


import com.example.firstproject.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Board extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bno;

    @Column(length = 50, nullable = false)
    private String title;

    @Column(length = 255, nullable = false)
    private String content;

    @Column(length = 50, nullable = false)
    private String writer;
}
