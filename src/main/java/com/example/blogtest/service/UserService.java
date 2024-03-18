package com.example.blogtest.service;

import com.example.blogtest.domain.User;
import com.example.blogtest.dto.AddUserRequest;
import com.example.blogtest.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;

    /*public UserService(UserRepository userRepository, BCryptPasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.encoder = encoder;
    }*/

    public void save(AddUserRequest request) {
        /*return userRepository.save(
                User.builder()
                        .email(dto.getEmail())
                        .password(encoder.encode(dto.getPassword()))    // 패스워드 암호화
                        .build()*/
        userRepository.save(new User(
                request.getEmail(),encoder.encode(request.getPassword())));
    }
    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
        return "redirect:/login";
    }
}

