package app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import entities.Emp;

public class UpdateOperation {

	public static void main(String[] args) {

		// create the service
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();

		// read the info hibernate.cfg.xml file
		Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();

		// actually conn to database
		SessionFactory sf = metadata.getSessionFactoryBuilder().build();

		// 1 dialog with database
		Session session = sf.openSession();

		Transaction tr = session.beginTransaction();

		Emp emp = session.get(Emp.class, 7369);
		
		emp.setSal(2000.00f);
		emp.setComm(100f);
		
		session.update(emp);
		
		System.out.println("Emp updated...");
		
		tr.commit();

		session.close();

		sf.close();
		
	}

}
