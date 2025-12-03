package app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import entities.Emp;

public class SaveOperation {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		Emp e = new Emp();
		e.setEmpno(13000);
		e.setEname("Chirag");
		e.setJob("Manager");
		e.setSal(34000.0f);

		// create the service
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();

		// read the info hibernate.cfg.xml file
		Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();

		// actually conn to database
		SessionFactory sf = metadata.getSessionFactoryBuilder().build();

		// 1 dialog with database
		Session session = sf.openSession();

		Transaction tr = session.beginTransaction();

		session.save(e);

		System.out.println("Emp saved");

		tr.commit();

		session.close();

		sf.close();

	}

}
