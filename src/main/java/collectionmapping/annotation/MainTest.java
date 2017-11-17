package collectionmapping.annotation;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

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
				configure("config/collectionmapping/annotation/hibernate.cfg.xml").build();
		
		SessionFactory sessionFactory = new MetadataSources(registry).
				buildMetadata().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Transaction t = session.beginTransaction();
		
		//测试映射列表
		//testSet(session);
		testList(session);
		
		t.commit();
		
		
		
        session.close();
        System.out.println("success");
		
		
		
		
		
		
		
	}

	private static void testSet(Session session) {
//		Item i1 = new Item();
//		i1.setName("Foo");
//		Set<String> set1 = new HashSet<String>();
//		set1.add("foo.jpg");
//		set1.add("bar.jpg");
//		set1.add("baz.jpg");
//		i1.setImages(set1);
//		Item i2 = new Item();
//		Set<String> set2 = new HashSet<String>();
//		set2.add("b.jpg");
//		i2.setName("B");
//		i2.setImages(set2);
//		Item i3 = new Item();
//		i3.setName("C");
//		
//		session.persist(i1);
//		session.persist(i2);
//		session.persist(i3);
	}
	
	private static void testList(Session session) {
		Item i1 = new Item();
		i1.setName("Foo");
		List<String> list1 = new ArrayList<String>();
		list1.add("foo.jpg");
		list1.add("bar.jpg");
		list1.add("baz.jpg");
		list1.add("baz.jpg");
		i1.setImages(list1);
		Item i2 = new Item();
		List<String> list2 = new ArrayList<String>();
		list2.add("b.jpg");
		i2.setName("B");
		i2.setImages(list2);
		Item i3 = new Item();
		i3.setName("C");
		
		session.persist(i1);
		session.persist(i2);
		session.persist(i3);
	}
}
