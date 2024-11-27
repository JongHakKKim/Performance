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
    @Size(min = 2, max = 10)
    private String cname;

    @Email
    @NotBlank
    @Size(min = 2, max = 20)
    private String email;

    @NotBlank
    @Size(min = 4, max = 10)
    private String password;

    private String address;

    private Role role;

    /*public Customer dtoToEntity (CustomerDTO customerDTO){
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        Customer customer = new Customer();
        customer.setName(customerDTO.getName());
        customer.setEmail(customerDTO.getEmail());
        customer.setAddress(customerDTO.getAddress());


        customer.setPassword(passwordEncoder.encode(customerDTO.getPassword()));
        customer.setRole(Role.ADMIN);

        return customer;
    }*/
}
