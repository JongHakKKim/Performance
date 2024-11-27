package com.example.firstproject.entity;

import com.example.firstproject.constant.ReservationStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "ticket")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {

    @Id
    @Column(name = "ticket_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    // 예매 아이디

    private String seatNumber;  // 좌석 번호

    private int price;      // 예매 가격

    @Temporal(TemporalType.TIMESTAMP)
    private Date reservationTime;   // 예매 시간

    @Temporal(TemporalType.TIMESTAMP)
    private Date cancellationTime;   // 취소 시간

    @Lob
    private String paymentInfo; // 결제 정보


    @Enumerated(EnumType.STRING)
    private ReservationStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "performance_id")
    private Performance performance;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Performance customer;
}
