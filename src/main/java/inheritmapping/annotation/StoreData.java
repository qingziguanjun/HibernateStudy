package inheritmapping.annotation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class StoreData {
	public static void main(String[] args) {
        // Session session = new
        // AnnotationConfiguration().configure().buildSessionFactory().openSession();
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("config/inheritmapping/anotation/hibernate.cfg.xml").build();
        // 2. 根据服务注册类创建一个元数据资源集，同时构建元数据并生成应用一般唯一的的session工厂
        SessionFactory sessionFactory = new MetadataSources(registry)
                .buildMetadata().buildSessionFactory();

        /**** 上面是配置准备，下面开始我们的数据库操作 ******/
        Session session = sessionFactory.openSession();// 从会话工厂获取一个session
        Transaction t = session.beginTransaction();

        Employee e1 = new Employee();
        e1.setName("Yiibai");

        Regular_Employee e2 = new Regular_Employee();
        e2.setName("Max su");
        e2.setSalary(50000);
        e2.setBonus(5);

        Contract_Employee e3 = new Contract_Employee();
        e3.setName("Hippo su");
        e3.setPay_per_hour(1000);
        e3.setContract_duration("15 hours");

        session.persist(e1);
        session.persist(e2);
        session.persist(e3);

        t.commit();
        session.close();
        System.out.println("success");
    }
}