package com.example.firstproject.dto;

import lombok.Data;

@Data
public class FindIdRequestDTO {
    private String name;  // 사용자 이름
    private String email; // 사용자 이메일
}
