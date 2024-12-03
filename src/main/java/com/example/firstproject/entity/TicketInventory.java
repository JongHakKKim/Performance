package com.example.firstproject.entity;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TicketInventory {

    private Long id; // 재고 ID

    @NotNull(message = "공연 정보는 필수입니다.")
    private Long performanceId; // 공연 ID

    @NotNull(message = "공연 이름은 필수입니다.")
    private String performanceName; // 공연 이름 (옵션)

    @Min(value = 1, message = "총 좌석 수는 1 이상이어야 합니다.")
    private int totalSeats; // 총 좌석 수

    @Min(value = 0, message = "잔여 티켓 수는 0 이상이어야 합니다.")
    private int availableTickets; // 잔여 티켓 수
}
