package eleks.com.ebean;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//Your entity maps across to a table name that is an SQL reserved keyword (User). 
//Sadly for you, your chosen JPA provider does not automatically quote the table 
//name identifier, and so you get exceptions when referring to the table.
//Solution is either to quote the table name yourself in the @Table annotation, 
//or change the table name to not be a reserved keyword. 
//Alternatively use a JPA provider that auto-quotes such reserved keywords for you 
//(e.g DataNucleus)
public class Eleks {

	
	public static void main(String[] args) {
		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		for (int i = 1; i < 6; i++) {
			String str = "User " + i;
			User user = new User(i, str);
			session.save(user);
		}
		session.getTransaction().commit();
		session.close();
		System.out.println("Successfully added...");
	}
}
