package com.example.demo;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

    // Returns JSP page named "hello.jsp"
    @GetMapping("/hello")
    public String hello() {
        return "hello"; // Make sure you have /WEB-INF/jsp/hello.jsp
    }

    // Returns plain text as REST response
    @GetMapping("/greet")
    @ResponseBody
    public String greet() {
        return "Hello User...";
    }

    // Returns JSON array
    @GetMapping("/nums")
    @ResponseBody
    public List<Integer> numbers() {
        return Arrays.asList(10, 20, 30, 40, 50);
    }

    // New API for testing
    @GetMapping("/welcome")
    @ResponseBody
    public String welcome() {
        return "Welcome to Spring Boot Testing!";
    }
}
