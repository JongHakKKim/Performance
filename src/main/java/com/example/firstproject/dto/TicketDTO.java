package com.example.firstproject.dto;

import com.example.firstproject.constant.ReservationStatus;
import com.example.firstproject.entity.Performance;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TicketDTO {

    private Long id;    // 예매 아이디

    @NotBlank(message = "좌석 번호는 필수입니다.")
    private String seatNumber;  // 좌석 번호

    @Min(value = 0, message = "예매 가격은 0원 이상이어야 합니다.")
    private int price;      // 예매 가격

    @NotNull(message = "예매 시간은 필수입니다.")
    private Date reservationTime;   // 예매 시간

    private Date cancellationTime;  // 취소 시간 (Optional)

    private String paymentInfo;     // 결제 정보 (Optional)

    private ReservationStatus status;  // 예매 상태

    @NotNull(message = "공연 정보는 필수입니다.")
    private Long performanceId;     // 공연 ID

    private String performanceName; // 공연 이름 (선택적으로 포함)

    @NotNull(message = "고객 정보는 필수입니다.")
    private Long customerId;        // 고객 ID

    private String customerName;    // 고객 이름 (선택적으로 포함)

}
