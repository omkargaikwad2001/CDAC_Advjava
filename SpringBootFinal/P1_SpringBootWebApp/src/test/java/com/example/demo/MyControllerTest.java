package com.example.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(MyController.class)
public class MyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Test hello JSP page")
    void testHelloPage() throws Exception {
        mockMvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(view().name("hello")); // Checks returned JSP name
    }

    @Test
    @DisplayName("Test greet API")
    void testGreet() throws Exception {
        mockMvc.perform(get("/greet"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello User..."));
    }

    @Test
    @DisplayName("Test welcome API")
    void testWelcome() throws Exception {
        mockMvc.perform(get("/welcome"))
                .andExpect(status().isOk())
                .andExpect(content().string("Welcome to Spring Boot Testing!"));
    }

    @Test
    @DisplayName("Test numbers API returns JSON array")
    void testNumbers() throws Exception {
        mockMvc.perform(get("/nums"))
                .andExpect(status().isOk())
                .andExpect(content().json("[10,20,30,40,50]"));
    }
}
