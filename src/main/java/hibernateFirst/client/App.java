package hibernateFirst.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import hibernateFirst.entity.Employee;

public class App {

	public static void main(String[] args) {
		Employee emp = new Employee(8,"Swadha","Female",567890);
		
		Configuration cfg = new Configuration().configure("hibernate.cfg1.xml");
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(emp);
		tx.commit();
		
	}

}
