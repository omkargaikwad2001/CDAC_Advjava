package app;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import entities.Emp;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class CriteriaQueryDemo {

	public static void main(String[] args) {
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		
		//read the info hibernate.cfg.xml file
		Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
								
		//actually conn to database
		SessionFactory sf = metadata.getSessionFactoryBuilder().build();	
		
		Session session = sf.openSession();
		
		//1
		CriteriaBuilder builder = session.getCriteriaBuilder();
		//2
		CriteriaQuery<Emp> query = builder.createQuery(Emp.class);
		//3 - from
		Root<Emp> root = query.from(Emp.class);  //emp table
		//4 - select
		query.select(root);   //select all properties
		//5. create query
		Query<Emp> q = session.createQuery(query);  //query - string
        //6 execute query
		List<Emp> emps = q.getResultList();
		for(Emp e : emps)
			System.out.println(e);   //e.toString()
	}

}
