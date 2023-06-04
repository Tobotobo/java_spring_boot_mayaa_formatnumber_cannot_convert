package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.form.HelloForm;

@Controller
public class HelloController {
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("ccc", 3456);
        model.addAttribute("ddd", "4567");
        model.addAttribute("helloForm", new HelloForm());
        return "hello";
    }
}
