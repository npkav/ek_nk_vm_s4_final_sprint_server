package com.keyin.server;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String home() {
        return "Hello! Spring Boot is running successfully! 🎉";
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello, World! Your Spring Boot application is working perfectly!";
    }

    @GetMapping("/status")
    public String status() {
        return "Application Status: Running ✅";
    }
} 