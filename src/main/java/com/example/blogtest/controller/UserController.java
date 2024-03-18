package com.example.blogtest.controller;

import com.example.blogtest.dto.AddUserRequest;
import com.example.blogtest.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

//@RequiredArgsConstructor
@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public String signup(AddUserRequest request) { //form action = method="post"/>
        userService.save(request);  // 회원 가입(저장)
        return "redirect:/login";   // 회원 가입 처리 후 로그인 페이지로 강제 이동
    }
}