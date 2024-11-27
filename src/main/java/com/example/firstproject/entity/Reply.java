package com.example.firstproject.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reply_num")
    private Long rno;

    private String replyText;

    private String writer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bno")
    private Board board;
}
