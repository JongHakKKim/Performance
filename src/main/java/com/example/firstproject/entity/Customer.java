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

    private String cname;

    @Column(unique = true , nullable = false)
    private String email;

    private String password;

    private String address;

    @Enumerated(EnumType.STRING)
    private Role role;
}
