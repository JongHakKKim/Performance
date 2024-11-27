package com.example.firstproject.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "performance")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Performance {

    @Id
    @Column(name = "performance_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String pname;

    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate; // 공연 시작일

    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;   // 공연 종료일

    private String timeInfo; // 공연시간 안내

    private int basePrice; // 기본 판매가

    private int totalSeats; // 판매 좌석수

    @Temporal(TemporalType.TIMESTAMP)
    private Date salesEndTime; // 판매 마감 시간

    @Lob
    private String remarks;     // 공연 유의사항

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Performance customer;
}
