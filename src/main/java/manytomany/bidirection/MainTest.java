package manytomany.bidirection;



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
		
		Person test = session.getReference(Person.class, 4L);
		Person test2 = session.find(Person.class, 1L);
		Person test3 = session.find(Person.class, 1L);
		System.out.println(test == test3);
		System.out.println(test2 == test3);
		Person person1 = new Person( "ABC-123" );
		Person person2 = new Person( "DEF-456" );

		Address address1 = new Address( "12th Avenue", "12A", "4005A" );
		Address address2 = new Address( "18th Avenue", "18B", "4007B" );

		person1.addAddress( address1 );
		person1.addAddress( address2 );

		person2.addAddress( address1 );

		session.persist( person1 );
		session.persist( person2 );

		session.flush();

		//person1.removeAddress( address1 );
		
		t.commit();
        session.close();
        System.out.println("success");
		
		
		
		
		
		
		
	}
}
