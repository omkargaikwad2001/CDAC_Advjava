package com.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.entity.Emp;
import com.entity.PermanentEmp;
import com.entity.TemporaryEmp;


public class InheritanceSave {

	public static void main(String[] args) {

		// create the service
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();

		// read the info hibernate.cfg.xml file
		Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();

		// actually conn to database
		SessionFactory sf = metadata.getSessionFactoryBuilder().build();

		// 1 dialog with database
		Session session = sf.openSession(); // TODO Auto-generated method stub

		Emp e1 = new PermanentEmp(1,"Omkar","omkar@gmail.com","787878",898950.0f,500.0f,4000.0f,100.0f);
		
		Emp e2 = new TemporaryEmp(2, "Amit", "Amit@gmail.com", "565656", 5623.0f, 7889.0f, 800.0f);
		
		Transaction tr1 = session.beginTransaction();
		
		session.save(e1);
		session.save(e2);
		
		tr1.commit();

		session.close();

		sf.close();

	}

}
