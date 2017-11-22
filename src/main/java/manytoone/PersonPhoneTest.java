package manytoone;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class PersonPhoneTest {
	public static void main(String[] args) {
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().
				configure("config/manytoone/hibernate.cfg.xml").build();
		
		SessionFactory sessionFactory = new MetadataSources(registry).
				buildMetadata().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Transaction t = session.beginTransaction();
		
		Person person = new Person();
		session.persist( person );

		Phone phone = new Phone( "123-456-7890" );
		phone.setPerson( person );
		session.persist( phone );

		session.flush();
		phone.setPerson( null );

		
		t.commit();
        session.close();
        System.out.println("success");
		
		
		
		
		
		
		
	}
}
