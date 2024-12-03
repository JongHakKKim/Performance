package com.example.firstproject.dto;

import com.example.firstproject.entity.Performance;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ticket_inventory")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TicketInventoryDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "performance_id")
    private Performance performance; // 공연 정보

    private int totalSeats; // 총 좌석 수

    private int availableTickets; // 잔여 티켓 수
}
