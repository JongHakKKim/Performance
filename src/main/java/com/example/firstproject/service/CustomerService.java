package com.example.firstproject.service;


import com.example.firstproject.dto.CustomerDTO;
import com.example.firstproject.entity.Customer;
import com.example.firstproject.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@Transactional
@RequiredArgsConstructor

public class CustomerService implements UserDetailsService {

    private final CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String cname) throws UsernameNotFoundException {

        Customer customer =
                customerRepository.findByCname(cname);

        if(customer == null){
            throw new UsernameNotFoundException(cname);
        }

        return User.builder()
                .username(customer.getCname())    //세션에 저장됨
                .password(customer.getPassword()) // 로그인시 입력한 비밀번호와 비교할값
                .roles(customer.getRole().name())
                .build();
    }

    public Customer saveCustomer(CustomerDTO customerDTO){

        try {
            // 회원가입여부 확인
            validateDuplicateCustomer(customerDTO.getCname() , customerDTO.getEmail(), customerDTO.getPhoneNumber());

            // DTO를 Entity로 변환
            Customer customer = customerDTO.dtoToEntity(customerDTO);

            // 데이터 저장
            return customerRepository.save(customer);

        } catch (org.springframework.dao.DataIntegrityViolationException e) {
            // 데이터베이스 중복 제약 조건 처리
            if (e.getMessage().contains("UKdwk6cx0afu8bs9o4t536v1j5v")) { // 유니크 키 이름 확인
                throw new IllegalStateException("이미 사용 중인 이메일입니다.");
            }
            throw e; // 기타 예외는 다시 던짐
        }

    }

    public void validateDuplicateCustomer(String cname, String email, String phoneNumber){

        // customer 이 null 이라는건 db에 회원가입이
        // 되어있지 않은 email이니 회원가입이 가능하고
        // null이 아니라는건 db에 회원이 가입되어있으니
        // 회원가입을 막거나 예외처리등을 수행하자

        // 아이디 중복 검사
        if (customerRepository.findByCname(cname) != null) {
            throw new IllegalStateException("이미 사용 중인 아이디입니다.");
        }

        // 이메일 중복 검사
        if (customerRepository.findByEmail(email) != null) {
            throw new IllegalStateException("이미 사용 중인 이메일입니다.");
        }

        // 휴대폰 번호 중복 검사
        if (customerRepository.findByPhoneNumber(phoneNumber) != null) {
            throw new IllegalStateException("이미 사용 중인 휴대폰 번호입니다.");
        }

    }

    public class StringToDate {
        public static void main(String[] args) throws ParseException {

            // 문자열
            String birthdate = "2021년 06월 19일 21시 05분 07초";

            // 포맷터
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");

            // 문자열 -> Date
            Date date = formatter.parse(birthdate);

            System.out.println(date); // Sat Jun 19 21:05:07 KST 2021
        }
    }



    public Customer findByNameAndEmail(String name, String email) {
        return customerRepository.findByNameAndEmail(name, email).orElse(null);
    }


}
