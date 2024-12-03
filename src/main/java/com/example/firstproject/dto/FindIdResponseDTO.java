package com.example.firstproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FindIdResponseDTO {
    private String name;      // 사용자 이름
    private String username;  // 사용자 아이디
}
