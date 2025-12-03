package com.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.entity.Category;
import com.entity.Products;

public class SaveProducts {

	public static void main(String[] args) {

		// Create Category first (assuming you have Category data)
		Category category = new Category();
		category.setCid(1); // Set appropriate category ID
		// category.setName("Electronics"); // Add other fields as needed

		// Fill Products data
		Products p = new Products();
		p.setName("Phone");
		p.setPrice(20000.0f);
		p.setCatid(category);

		// create the service
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();

		// read the info hibernate.cfg.xml file
		Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();

		// actually conn to database
		SessionFactory sf = metadata.getSessionFactoryBuilder().build();

		// 1 dialog with database
		Session session = sf.openSession();

		Transaction tr = session.beginTransaction();

		session.save(p);

		System.out.println("Product saved...");

		tr.commit();

		session.close();

		sf.close();

	}

}
