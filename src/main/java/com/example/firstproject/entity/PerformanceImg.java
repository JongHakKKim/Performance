package com.example.firstproject.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString(exclude = "performance")
@Table(name = "performance_img")
@NoArgsConstructor
public class PerformanceImg {

    @Id
    @Column(name = "performance_img_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imgName;  //이미지 파일명

    private String oriImgName; //원본 이미지명

    private String imgUrl; //이미지 조회 경로

    private String repimgYn; //대표이미지 여부


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "performance_id")
    private Performance performance;
}
