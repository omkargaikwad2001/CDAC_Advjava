package com.example.demo;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.demo.controllers.GreetController;
import com.example.demo.services.GreetingService;

@WebMvcTest(controllers = GreetController.class)
public class GreetControllerTest {
	
	@Autowired
	MockMvc mvc;
	
	@MockitoBean
	GreetingService grservice;
	
	@Test
	public void testgreet() throws Exception{
		Mockito.when(grservice.greet()).thenReturn("welcome to spring testing");
		
		mvc.perform(MockMvcRequestBuilders.get("/greet"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.content().string("welcome to spring testing"));
		
	}

	
}
