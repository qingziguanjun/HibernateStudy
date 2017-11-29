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


public class MainTest {
	public static void main(String[] args) {
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().
				configure("config/manytoone/hibernate.cfg.xml").build();
		
		SessionFactory sessionFactory = new MetadataSources(registry).
				buildMetadata().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Transaction t = session.beginTransaction();
		
		Item someItem = new Item("Some Item");
		session.persist(someItem);
		
		Bid someBid = new Bid(1235L, someItem);
		someItem.getBids().add(someBid);
		//Item 注解里有 cascade，就不需要下面保存了
		//但是session.persist(someItem) 必须在 add后面，不然只保存item
		session.persist(someBid);
		
		Bid someBid2 = new Bid(4565L, someItem);
		someItem.getBids().add(someBid2);
		session.persist(someBid2);
		
		session.persist(someItem);
		t.commit();
		
		//要是能取得成功，类必须要有默认构造函数方法
//		Item item = session.find(Item.class, 10);
////		for(Bid bid: item.getBids()){
////			session.remove(bid);
////		}
//		session.remove(item);
		t.commit();
        session.close();
        System.out.println("success");
		
		
		
		
		
		
		
	}
}
