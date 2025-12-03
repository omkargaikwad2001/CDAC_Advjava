package app;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.NativeQuery;

public class UsingSqlQuery {
	public static void main(String[] args) {
		//create the service
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
								
		//read the info hibernate.cfg.xml file
		Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
								
		//actually conn to database
		SessionFactory sf = metadata.getSessionFactoryBuilder().build();	
		
		Session session = sf.openSession();
		
		//native query - complicated, multiple join
		NativeQuery q = session.createNativeQuery("select e.empno, e.mgr, e1.ename from emp e, emp e1 where e.mgr = e1.empno");
				
		List<Object[]> list = q.getResultList();
		
		for(Object [] emp : list) {
			System.out.println(emp[0]+" : "+emp[1]+" : "+emp[2]);
		}
		
		session.close();
		
		sf.close();
		
		

	}

}
