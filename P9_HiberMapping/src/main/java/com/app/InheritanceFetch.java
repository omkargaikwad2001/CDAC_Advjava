package com.app;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.entity.PermanentEmp;
import com.entity.TemporaryEmp;

public class InheritanceFetch {

	public static void main(String[] args) {
		
		// create the service
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();

		// read the info hibernate.cfg.xml file
		Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();

		// actually conn to database
		SessionFactory sf = metadata.getSessionFactoryBuilder().build();

		// 1 dialog with database
		Session session = sf.openSession();

		PermanentEmp per = session.get(PermanentEmp.class, 1);
		
		System.out.println("PermanentEmp data");
		System.out.println(per.getId());
		System.out.println(per.getName());
		System.out.println(per.getEmail());
		System.out.println(per.getContactno());
		System.out.println(per.getBasic());
		System.out.println(per.getAllowance());
		System.out.println(per.getBonus());
		System.out.println(per.getDeduction());
		
		TemporaryEmp per2 = session.get(TemporaryEmp.class, 2);
		
		System.out.println("TemporaryEmp data");
		System.out.println(per2.getId());
		System.out.println(per2.getName());
		System.out.println(per2.getEmail());
		System.out.println(per2.getContactno());
		System.out.println(per2.getBasic());
		System.out.println(per2.getExtrapay());
		System.out.println(per2.getTaxes());
		
		session.close();
		sf.close();
		
	}

}
