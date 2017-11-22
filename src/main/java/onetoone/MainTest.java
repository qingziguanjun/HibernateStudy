package onetoone;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Embeddable;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class MainTest {
	public static void main(String[] args) {
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().
				configure("config/onetoone/hibernate.cfg.xml").build();
		
		SessionFactory sessionFactory = new MetadataSources(registry).
				buildMetadata().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Transaction t = session.beginTransaction();
		
		Address someAddress = new Address("Some street 123", "12456", "Some City");
		session.persist(someAddress);
		
		User someUser = new User(someAddress.getId(), "johndoe");
		someUser.setShippingAddress(someAddress);
		session.persist(someUser);		
		t.commit();
        session.close();
        System.out.println("success");
		
		
		
		
		
		
		
	}
}
