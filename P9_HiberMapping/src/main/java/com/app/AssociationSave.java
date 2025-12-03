package com.app;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.entity.Category;
import com.entity.Products;

public class AssociationSave {

	public static void main(String[] args) {
		
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		
		Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
		
		SessionFactory sf = metadata.getSessionFactoryBuilder().build();
		
		Session session = sf.openSession();
		
		/*
		//saving new master - does not have child
		Category cat = new Category(3,"Sports","All Sports items available");
		
		Transaction tr = session.beginTransaction();
		
		session.save(cat);
		System.out.println("category added...");
		
		tr.commit();
		 */
		
		
		/*
		//save child for existing master
		Category c = session.get(Category.class,3);
		Products p = new Products();
		p.setName("Bat");
		p.setPrice(6000.0f);
		p.setCatid(c);
		
		Transaction tr = session.beginTransaction();
		
		session.save(p);
		System.out.println("Products saved with child");
		
		tr.commit();
		*/
		
		//save Category with  products
		//having @Cascade is required on onetomany side
		
		Category cat = new Category(4,"Cloths","All cloths available");	  //new master
		Products p1 = new Products("T-Shirt",300.0f);   //child1 - master's new entry
		Products p2 = new Products("pant",500.0f);   //child2

		Set<Products>items =new HashSet<Products>();
		items.add(p1);
		items.add(p2);
		
		cat.setItems(items);
		
		Transaction tr = session.beginTransaction();
		
		session.save(cat);
		System.out.println("Child data added with master...");
		
		tr.commit();
		
		session.close();
		sf.close();
	
	}

}
