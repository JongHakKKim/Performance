package com.example.firstproject.entity;

import com.example.firstproject.constant.Role;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Entity
@Table(name = "customer")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @Column(name = "customer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String cname;

    @Column(unique = true , nullable = false)
    private String email;

    private String password;

    // 주소 관련 필드 추가
    @Column(nullable = false)
    private String postcode;       // 우편번호
    @Column(nullable = false)
    private String address;        // 기본 주소
    @Column(nullable = false)
    private String detailAddress;  // 상세 주소

    private String extraAddress;   // 참고 항목 (선택 사항)

    private String nickname;

    private String birthdate;

    @Column(nullable = false, unique = true)
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private Role role;
}
