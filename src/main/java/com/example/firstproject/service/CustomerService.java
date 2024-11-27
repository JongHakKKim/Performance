package com.example.firstproject.service;


import com.example.firstproject.entity.Customer;
import com.example.firstproject.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor

public class CustomerService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        /*Customer customer =
                CustomerRepository.findByEmail(email);*/

        return null;
    }
}
