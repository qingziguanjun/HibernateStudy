package firstanotation;

import java.util.WeakHashMap;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnitUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class TestEM {
	public static void main(String[] args) {
		 //Session session = new AnnotationConfiguration().configure().buildSessionFactory().openSession();
	    final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("config/firstanotation/hibernate.cfg.xml")
	            .build();
	    // 2. 根据服务注册类创建一个元数据资源集，同时构建元数据并生成应用一般唯一的的session工厂
	    SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
	
	    /**** 上面是配置准备，下面开始我们的数据库操作 ******/
	  //  Session session = sessionFactory.openSession();// 从会话工厂获取一个session
	    EntityManager em = sessionFactory.createEntityManager();
	    
	   // Transaction t = session.beginTransaction();
	
	    Employee e1 = new Employee();
	   // e1.setId(1001);
	    e1.setFirstName("Yii");
	    e1.setLastName("Bai");
	
	    Employee e2 = new Employee();
	    //e2.setId(1002);
	    e2.setFirstName("Min");
	    e2.setLastName("Su");
	
	    System.out.println(em.contains(e1));
	    em.persist(e1);
	    em.persist(e2);
	    System.out.println( em.contains(e1));
	   // t.commit();
	    em.close();
	    System.out.println( em.contains(e1));
	    System.out.println("successfully saved");
	}
}
