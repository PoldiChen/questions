package question071;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSession {
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session1 = sessionFactory.openSession();
		Session session2 = sessionFactory.openSession();
		Session session3 = sessionFactory.getCurrentSession();
		Session session4 = sessionFactory.getCurrentSession();
		System.out.println(session1.hashCode());
		System.out.println(session2.hashCode()); // 1和2的hashcode不同
		System.out.println(session3.hashCode());
		System.out.println(session4.hashCode()); // 3和4的hashcode相同
				
	}

}
