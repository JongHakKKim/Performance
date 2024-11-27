package com.example.firstproject.dto;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PerformanceDTO {

    private Long id;

    @NotBlank
    @Size(min = 2, max = 10,message = "이름은 2자 이상 10자이하로 작성해주세요")
    private String pname;

    @NotNull(message = "공연 시작일은 필수 항목입니다.")
    private Date startDate; // 공연 시작일

    @NotNull(message = "공연 종료일은 필수 항목입니다.")
    private Date endDate;   // 공연 종료일

    @NotNull(message = "공연 시간안내는 필수 항목입니다.")
    private String timeInfo; // 공연시간 안내

    @Min(value = 0, message = "기본 판매가는 0원 이상이어야 합니다.")
    private int basePrice; // 기본 판매가

    @Min(value = 1, message = "최소 1석 이상의 좌석 수가 필요합니다.")
    private int totalSeats; // 판매 좌석수

    @NotNull(message = "판매 마감 시간은 필수 항목입니다.")
    private Date salesEndTime; // 판매 마감 시간

    private String remarks;     // 공연 유의사항

    private Long customerId;
}
