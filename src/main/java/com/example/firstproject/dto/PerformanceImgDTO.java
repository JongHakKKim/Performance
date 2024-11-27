package com.example.firstproject.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PerformanceImgDTO {


    public Long ino;

    private String imgPath;

    private String imgName;

    //uuid사용시
    private String newImgName;

    private PerformanceDTO performanceDTO;   // pk값으로 객체를 가져와서 담을 객체타입으로 작성하여 참조한다.

}
