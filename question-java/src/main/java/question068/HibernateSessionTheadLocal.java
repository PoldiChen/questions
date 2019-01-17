package question068;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionTheadLocal {
	
	@SuppressWarnings("rawtypes")
	public static final ThreadLocal LOCAL = new ThreadLocal();
	
	@SuppressWarnings("deprecation")
	private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	
	@SuppressWarnings("unchecked")
	public static Session currentSession() throws HibernateException {
		Session session = (Session) LOCAL.get();
		if (session == null) {
			session = sessionFactory.openSession();
			LOCAL.set(session);
		}
		return session;
	}

}
