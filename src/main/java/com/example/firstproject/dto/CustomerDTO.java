package com.example.firstproject.dto;

import com.example.firstproject.constant.Role;
import com.example.firstproject.entity.Customer;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {

    private Long id;

    @NotBlank
    @Size(min = 2, max = 10 , message = "아이디는 2자 이상, 10자 이하로 입력해주세요.")
    private String cname;

    @Email(message = "유효한 이메일 주소를 입력해주세요.")
    @NotBlank(message = "이메일은 필수 입력 항목입니다.")
    @Size(min = 2, max = 20)
    private String email;

    @NotBlank(message = "비밀번호는 필수 입력 항목입니다.")
    @Size(min = 4, max = 10 , message = "비밀번호는 4자 이상, 10자 이하로 입력해주세요.")
    private String password;

    @NotBlank(message = "주소는 필수 입력 항목입니다.")
    private String address;

    @NotBlank(message = "닉네임은 필수 입력 항목입니다.")
    private String nickname;

    @NotBlank(message = "생년월일은 필수 입력 항목입니다.")
    private String birthdate;

    @NotBlank(message = "휴대폰 번호는 필수 입력 항목입니다.")
    @Size(min = 10, max = 13, message = "휴대폰 번호는 10자 이상, 13자 이하로 입력해주세요.")
    private String phoneNumber;

    private Role role;

    public Customer dtoToEntity (CustomerDTO customerDTO){
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        Customer customer = new Customer();
        customer.setCname(customerDTO.getCname());
        customer.setEmail(customerDTO.getEmail());
        customer.setPassword(passwordEncoder.encode(customerDTO.getPassword()));
        customer.setAddress(customerDTO.getAddress());
        customer.setNickname(customerDTO.getNickname());
        customer.setBirthdate(customerDTO.getBirthdate());
        customer.setPhoneNumber(customerDTO.getPhoneNumber());
        customer.setRole(Role.USER);

        return customer;
    }
}
