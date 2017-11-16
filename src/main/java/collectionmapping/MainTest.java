package collectionmapping;


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
				configure("config/collectionmapping/hibernate.cfg.xml").build();
		
		SessionFactory sessionFactory = new MetadataSources(registry).
				buildMetadata().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Transaction t = session.beginTransaction();
		
		ArrayList<String> list = new ArrayList<String>();
		list.add("java is a programing language");
		list.add("java is a platform");
		
		ArrayList<String> list2 = new ArrayList<String>();
		list2.add("Servlet is a Interface");
		list2.add("Servlet is a Api");
		
		Question question1 = new Question();
		question1.setName("Java 是什么？");
		question1.setAnswers(list);
		
		Question question2 = new Question();
		question2.setName("Hibernate 是什么？");
		question2.setAnswers(list2);
		
		 session.persist(question1);
	     session.persist(question2);
		
		t.commit();
		
		
		 // 查询数据
        Query<Question> query = session.createQuery("from Question");
        List<Question> list3 =query.list();

        Iterator<Question> itr = list3.iterator();
        while (itr.hasNext()) {
            Question q = itr.next();
            System.out.println("Question Name: " + q.getName());

            // printing answers
            List<String> list21 = q.getAnswers();
            Iterator<String> itr2 = list21.iterator();
            while (itr2.hasNext()) {
                System.out.println(itr2.next());
            }

        }
        session.close();
        System.out.println("success");
		
		
		
		
		
		
		
	}
}
