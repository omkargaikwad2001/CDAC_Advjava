package com.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.entity.Category;
import com.entity.Products;

public class GetAllProducts {

	public static void main(String[] args) {

		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
		SessionFactory sf = metadata.getSessionFactoryBuilder().build();

		Session session = sf.openSession();
		session.beginTransaction();

		Products product = session.get(Products.class, 1);

		System.out.println("=== Product Details ===");
		System.out.println("Pid = " + product.getPid());
		System.out.println("Name = " + product.getName());
		System.out.println("Price = " + product.getPrice());

		Category category = product.getCatid();
		System.out.println("\n=== Full Category Details ===");
		System.out.println("Category ID = " + category.getCid());
		System.out.println("Category Name = " + category.getCname());
		System.out.println("Category Description = " + category.getCdesc());

		session.getTransaction().commit();
		session.close();
		sf.close();

	}

}
