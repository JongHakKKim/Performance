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

        // 회원가입여부 확인
        validateDuplicateCustomer(customerDTO.getCname());

        //컨트롤러에서 받은  CustomerDTO를 customer entity로 변경

        Customer customer =
                customerDTO.dtoToEntity(customerDTO);

        customer =
                customerRepository.save(customer);

        return customer;
    }

    public void validateDuplicateCustomer(String cname){

        Customer customer =
                customerRepository.findByCname(cname);
        // customer 이 null 이라는건 db에 회원가입이
        // 되어있지 않은 email이니 회원가입이 가능하고
        // null이 아니라는건 db에 회원이 가입되어있으니
        // 회원가입을 막거나 예외처리등을 수행하자

        if(customer != null) {
            throw new IllegalStateException("이미 가입된 회원입니다.");
        }
        // 이 내용은 try{}catch(IllegalStateException e) {
        //          model.att~~("msg", e.get메시지)
        // return "u/signup";}
        // 처리가능

    }
}
