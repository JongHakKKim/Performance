package com.example.firstproject.service;

import com.example.firstproject.entity.Customer;
import com.example.firstproject.repository.CustomerRepository;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Log4j2
class CustomerServiceTest {

    /*@Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerRepository customerRepository;

    @Test
    String name = "홍길동";
    String email = "test@a.a";
    Customer customer = new Customer();
    customer.setName(name);
    customer.setEmail(email);
    customerRepository.save(customer);


    // When
    Customer foundCustomer = customerService.findByNameAndEmail(name, email);

    // Then
    assertNotNull(foundCustomer);
    assertEquals(name, foundCustomer.getName());
    assertEquals(email, foundCustomer.getEmail());*/

}