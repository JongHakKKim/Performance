package com.example.firstproject.repository;

import com.example.firstproject.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    // 로그인 한 유저정보 email을 통해서 각종 검색을 위한 기능
    // 등록시에도 사용
    // 로그인한사람의 아이템에서도 사용
    // 등록한 글을 수정할때 로그인한사람의 정보를 받아와서 글등록한사람과
    // 비교시에도 사용
    // 글을 댓글을 리뷰를 아이템을 삭제할때도 같아야 삭제하는데
    // 같은지 알려면 먼저 로그인한사람의 정보를 받아와야함으로 필요
    Customer findByCname(String cname);     // 아이디 중복 확인

    Customer findByEmail(String email);     // 이메일 중복 확인

    Customer findByPhoneNumber(String phoneNumber); // 휴대폰 번호 중복 확인

    Optional<Customer> findByNameAndEmail(String name, String email); // 아이디 찾기
}
