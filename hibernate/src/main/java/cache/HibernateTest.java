package cache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.hibernate.crud.UserDetails5;

public class HibernateTest {

	public static void main(String[] args) {


		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		UserDetails5 user = (UserDetails5) session.get(UserDetails5.class, 2);
		user.setUserName("Updated User");
		
		//UserDetails5 user2= (UserDetails5) session.get(UserDetails5.class, 2);
		
		session.getTransaction().commit();
		session.close();
		
		Session session2 = sessionFactory.openSession();
		session2.beginTransaction();
		
		UserDetails5 user2= (UserDetails5) session2.get(UserDetails5.class, 2);
		
		session2.getTransaction().commit();
		session2.close();
	}

	
}
