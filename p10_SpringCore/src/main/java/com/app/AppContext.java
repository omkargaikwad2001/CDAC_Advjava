package com.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.entity.Emp;

public class AppContext {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
		
		Emp e = (Emp)ctx.getBean("emp");
		
		System.out.println(e);
		
	}

}
