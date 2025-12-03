package com.app;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.entity.Category;
import com.entity.Products;

public class GetAllCategories {

	public static void main(String[] args) {

		// create the service
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();

		// read the info hibernate.cfg.xml file
		Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();

		// actually conn to database
		SessionFactory sf = metadata.getSessionFactoryBuilder().build();

		// 1 dialog with database
		Session session = sf.openSession();

		Category c = session.get(Category.class, 1);
		
		System.out.println("Cid = "+c.getCid());
		System.out.println("Cdesc = "+c.getCdesc());
		System.out.println("Cname = "+c.getCname());
		System.out.println("Items size = "+c.getItems().size());
		
		// Iterate over items
	    Set<Products> items = c.getItems();
	    for (Products product : items) {
	        System.out.println("Product: " + product.getName() + 
	                          " - Price: " + product.getPrice() + 
	                          " - PID: " + product.getPid());
	    }
		
		sf.close();

	}

}
