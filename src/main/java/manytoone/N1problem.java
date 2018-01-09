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

import firstanotation.Employee;


public class N1problem {
	public static void main(String[] args) {
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().
				configure("config/manytoone/hibernate.cfg.xml").build();
		
		SessionFactory sessionFactory = new MetadataSources(registry).
				buildMetadata().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Transaction t = session.beginTransaction();	
		//要是能取得成功，类必须要有默认构造函数方法
		//Item item = session.find(Item.class, 10);
		
		List<Item> items = session.createQuery("select i from Item i ").getResultList();
		
//		for(Item item :items){
//			item.getBids().size();
//		}
		t.commit();
        session.close();
        items.get(0).getBids().size();
        System.out.println("success");
		
		
		
		
		
		
		
	}
}
