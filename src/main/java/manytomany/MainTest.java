package manytomany;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class MainTest {
	public static void main(String[] args) {
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().
				configure("config/manytomany/hibernate.cfg.xml").build();
		
		SessionFactory sessionFactory = new MetadataSources(registry).
				buildMetadata().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Transaction t = session.beginTransaction();
		
		
//		Person person1 = new Person();
//		Person person2 = new Person();
//
//		Address address1 = new Address( "12th Avenue", "12A" );
//		Address address2 = new Address( "18th Avenue", "18B" );
//
//		person1.getAddresses().add( address1 );
//		person1.getAddresses().add( address2 );
//
//		person2.getAddresses().add( address1 );
//
//		session.persist( person1 );
//		session.persist( person2 );
//
//		session.flush();

		
		Person person1 = session.find(Person.class, 1L);
		session.remove(person1);
		//person1.getAddresses().remove( address1 );
		
		t.commit();
        session.close();
        System.out.println("success");
		
		
		
		
		
		
		
	}
}
