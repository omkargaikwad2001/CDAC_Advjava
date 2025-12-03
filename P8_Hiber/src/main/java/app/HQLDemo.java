package app;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;


public class HQLDemo {

	public static void main(String[] args) {
		//create the service
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
								
		//read the info hibernate.cfg.xml file
		Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
								
		//actually conn to database
		SessionFactory sf = metadata.getSessionFactoryBuilder().build();		
		
		Session session = sf.openSession();
		
		//query string - HQL - select * from emp
		/*Query<Emp> query = session.createQuery("from Emp", Emp.class);
		
		List<Emp> emps = query.getResultList();
		
		for(Emp e : emps) {
			System.out.println(e.getEmpno()+" : "+e.getEname()+" : "+e.getJob());
		}*/
		
		//query string - HQL - will be converted SQL - fetching few columns/properties
		/*Query<Object[]> query= session.createQuery("select empno, ename from Emp", Object[].class);
		List<Object[]> list = query.getResultList();
		for(Object [] obj : list) {
			System.out.println(obj[0]+" : "+obj[1]);
		}*/
		
		//2 types of parameters - named parameter, positional parameters
		//named parameter
		/*Query<Emp> q = session.createQuery("from Emp where deptno = :dno", Emp.class);
		q.setParameter("dno", 20);
		List<Emp> list = q.getResultList();
		for(Emp e : list) {
			System.out.println(e.getEmpno()+" : "+e.getDeptno());
		}*/
		
		/*Query<Object[]> q = session.createQuery("select empno,sal from Emp where deptno = ?1 and sal > ?2",Object[] .class);
		q.setParameter(1, 10);
		q.setParameter(2, 2000.0f );
		List<Object[]> list = q.getResultList();
		for(Object [] obj : list) {
			System.out.println(obj[0]+" : "+obj[1]);
		}*/
		
		/*
		Query<Double> q = session.createQuery("select avg(sal) from Emp",Double.class);
		Double avgsal = q.getSingleResult();
		System.out.println("Average salary : "+avgsal);
		*/
		
		/*Query query = session.createQuery("update Emp set comm = 1000 where comm < 1000");
		Transaction tr = session.beginTransaction();
		int n = query.executeUpdate();   //only if it is executed within transaction
		tr.commit();
		System.out.println(n + " records updated"); */
		
		Query<Object[]> q = session.createNamedQuery("getempsfromdept",Object[].class);
		q.setParameter("dno", 30);
		List<Object[]> list= q.getResultList();
		for(Object [] emp : list) {
			System.out.println(emp[0]+" : "+emp[1]);
		}
		
		session.close();
		
		sf.close();

	}

}
