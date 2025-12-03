package com.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.entity.Category;

public class SaveCategory {

	public static void main(String[] args) {
		
//		Category cat = new Category(1,"Electronics","All Electronics items available");
		Category cat = new Category(2,"Food","All Food items available");
		
		// create the service
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();

		// read the info hibernate.cfg.xml file
		Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();

		// actually conn to database
		SessionFactory sf = metadata.getSessionFactoryBuilder().build();

		// 1 dialog with database
		Session session = sf.openSession();

		Transaction tr = session.beginTransaction();

		session.save(cat);

		System.out.println("Category saved...");

		tr.commit();

		session.close();

		sf.close();

	}

}
