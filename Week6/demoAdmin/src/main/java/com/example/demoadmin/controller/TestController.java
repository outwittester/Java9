package com.example.demoadmin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class TestController {
    @GetMapping("test")
    public String test() {
        System.out.println(1/0);
        return "login";
    }

    @GetMapping("test/test")
    public String testtest() {
        return "login";
    }
}
