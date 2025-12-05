package com.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.entity.Trainer;

public class AutowireMain {

	public static void main(String[] args) {
		
		
//		This is with config.xml file
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
//		Trainer bean = ctx.getBean(Trainer.class);
//		System.out.println(bean.toString());
		
//		This is with Annotation + config.xml
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
//		Trainer bean = ctx.getBean(Trainer.class);
//		System.out.println(bean.toString());
		
//		This is with Annotation no config.xml and with @configuration and @bean
//		removing xml file
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(MyBean.class);
		Trainer bean = ctx.getBean(Trainer.class);
		System.out.println(bean);
		
		
	}

}
