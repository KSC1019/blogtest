package com.example.blogtest.controller;

import com.example.blogtest.domain.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class PageController {
    @GetMapping("/thymeleaf/example")
    public String thymeleafEx(Model model){
        Person person = new Person();
        person.setId(1L);
        person.setId(1L);
        person.setName("김자바");
        person.setAge(20);
        person.setHobbies(List.of("줄넘기", "멀리뛰기"));

        model.addAttribute("person", person);
        model.addAttribute("today", LocalDateTime.now());

        return "ExPage";
    }
}
