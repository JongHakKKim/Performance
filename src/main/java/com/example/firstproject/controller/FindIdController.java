package com.example.firstproject.controller;

import com.example.firstproject.dto.CustomerDTO;
import com.example.firstproject.dto.FindIdRequestDTO;
import com.example.firstproject.dto.FindIdResponseDTO;
import com.example.firstproject.entity.Customer;
import com.example.firstproject.service.CustomerService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String findIdPage(Model model) {
        model.addAttribute("customerDTO", new CustomerDTO()); // Model에 customerDTO 추가
        return "customer/findId";
    }

    @PostMapping("/findId")
    public String findId(
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            Model model) {
        log.info("아이디 찾기 요청: name={}, email={}", name, email);

        Customer customer = customerService.findByNameAndEmail(name, email);
        if (customer != null) {
            log.info("오류");
            log.info("오류");
            log.info("오류");
            log.info("오류");
            model.addAttribute("message", customer.getName() + "님의 아이디는 " + customer.getCname() + " 입니다.");
        } else {
            model.addAttribute("message", "해당 정보를 찾을 수 없습니다.");
        }

        // 다시 폼으로 돌아가기 위해 customerDTO를 추가
        model.addAttribute("customerDTO", new CustomerDTO());
        return "customer/findId";
    }
}
