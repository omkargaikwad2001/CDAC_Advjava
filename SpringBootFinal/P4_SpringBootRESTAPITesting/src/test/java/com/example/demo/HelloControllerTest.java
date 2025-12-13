package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.demo.controllers.HelloController;

@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {
	
	@Autowired
	MockMvc mvc;
	
	@Test
	public void testHello() throws Exception{
		mvc.perform(MockMvcRequestBuilders.get("/hello"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.content().string("Helloo"));
	}


}
