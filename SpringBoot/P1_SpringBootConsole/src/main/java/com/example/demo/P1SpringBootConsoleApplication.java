package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class P1SpringBootConsoleApplication {

	public static void main(String[] args) {
		ApplicationContext ctx =  SpringApplication.run(P1SpringBootConsoleApplication.class, args);
		
		String[] beans = ctx.getBeanDefinitionNames();
		
		for(String str:beans) {
			System.out.println(str);
		}
		
	}

}
