package com.example.firstproject.controller;

import com.example.firstproject.dto.FindIdRequestDTO;
import com.example.firstproject.dto.FindIdResponseDTO;
import com.example.firstproject.entity.Customer;
import com.example.firstproject.service.CustomerService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customers")
@Log4j2
public class FindIdController {

    private final CustomerService customerService;

    public FindIdController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/findId")
    public String findIdPage() {


        return "customer/findId";
    }

    @PostMapping("/findId")
    public ResponseEntity<?> findId(@RequestParam("name") String name, @RequestParam("email") String email) {
        Customer customer = customerService.findByNameAndEmail(name, email);

        if (customer != null) {
            return ResponseEntity.ok(new FindIdResponseDTO(customer.getNickname(), customer.getCname()));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }
}
