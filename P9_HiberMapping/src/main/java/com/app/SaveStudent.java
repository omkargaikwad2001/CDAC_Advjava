package com.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.entity.Address;
import com.entity.Student;

public class SaveStudent {

	public static void main(String[] args) {
		
		Student s = new Student(101,"Omkar",new Address("Deccan","pune","411023"));

		// create the service
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();

		// read the info hibernate.cfg.xml file
		Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();

		// actually conn to database
		SessionFactory sf = metadata.getSessionFactoryBuilder().build();

		// 1 dialog with database
		Session session = sf.openSession();

		Transaction tr = session.beginTransaction();

		session.save(s);

		System.out.println("Student saved...");

		tr.commit();

		session.close();

		sf.close();

	}

}
