package com.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.entity.Student;

public class GetallRecords {

	public static void main(String[] args) {

		// create the service
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();

		// read the info hibernate.cfg.xml file
		Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();

		// actually conn to database
		SessionFactory sf = metadata.getSessionFactoryBuilder().build();

		// 1 dialog with database
		Session session = sf.openSession();
		
		Student student = session.get(Student.class, 101);
		
		System.out.println("ID = "+student.getId());
		System.out.println("Name = "+student.getName());
		System.out.println("Area = "+student.getAddress().getArea());
		System.out.println("City = "+student.getAddress().getCity());
		System.out.println("Pin = "+student.getAddress().getPincode());
		
		sf.close();
	}

}
