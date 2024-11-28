package com.example.firstproject.controller;


import ch.qos.logback.core.joran.conditional.IfAction;
import com.example.firstproject.dto.CustomerDTO;
import com.example.firstproject.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/customers")
@Controller
@RequiredArgsConstructor
@Log4j2
public class CustomerController {

    private final CustomerService customerService;

    // 회원가입 페이지 GET 요청
    @GetMapping("/new")
    public String customerForm(Model model) {
        model.addAttribute("customerDTO", new CustomerDTO());
        return "customer/customerForm"; // 회원가입 페이지 경로
    }

    // 회원가입 처리 POST 요청
    @PostMapping("/new")
    public String customerFormPost(
            @Valid CustomerDTO customerDTO,
            BindingResult bindingResult,
            Model model) {

        log.info("회원가입 요청 데이터: {}", customerDTO);

        // 유효성 검사 실패 처리
        if (bindingResult.hasErrors()) {
            log.error("유효성 검사 실패: {}", bindingResult.getAllErrors());
            return "customer/customerForm"; // 에러 발생 시 다시 회원가입 페이지로 이동
        }

        try {
            customerService.saveCustomer(customerDTO); // 회원 정보 저장
        } catch (IllegalStateException e) {
            log.error("회원가입 중 예외 발생: {}", e.getMessage());
            model.addAttribute("msg", e.getMessage());
            return "customer/customerForm"; // 에러 메시지와 함께 다시 회원가입 페이지로 이동
        }

        // 회원가입 성공 후 로그인 페이지로 리다이렉트
        return "redirect:/customers/login";
    }

    // 로그인 페이지 GET 요청
    @GetMapping("/login")
    public String loginMember() {
        return "/customer/loginForm"; // 로그인 페이지 경로
    }
}
