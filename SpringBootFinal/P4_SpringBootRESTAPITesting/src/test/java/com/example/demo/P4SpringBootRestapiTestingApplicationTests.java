package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.controllers.GreetController;
import com.example.demo.controllers.HelloController;

@SpringBootTest
class P4SpringBootRestapiTestingApplicationTests {

	@Autowired
	HelloController hc;	
	@Autowired
	GreetController gc;

	@Test
	void contextLoads() {
		assertThat(hc).isNotNull();
		assertThat(gc).isNotNull();
	}


}
