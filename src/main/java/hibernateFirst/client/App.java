package hibernateFirst.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import hibernateFirst.entity.Employee;

public class App {

	public static void main(String[] args) {
		Employee emp = new Employee("Shruti","Female",567890);
//		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg1.xml").buildSessionFactory();
		
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg1.xml").build();
//		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory sessionFactory = new MetadataSources(ssr).getMetadataBuilder().build().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(emp);
		tx.commit();
		
	}

}
