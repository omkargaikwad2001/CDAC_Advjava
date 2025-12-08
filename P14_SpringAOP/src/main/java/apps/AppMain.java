package apps;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import entities.Emp;

public class AppMain {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("appContext.xml");
		Emp e = ctx.getBean(Emp.class);
		
		System.out.println(e.toString());
	}

}
