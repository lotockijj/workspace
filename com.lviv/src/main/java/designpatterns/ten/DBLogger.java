package designpatterns.ten;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class DBLogger implements Logger {
	private static DBLogger dbLogger;
	
	private DBLogger(){
	}
	
	public static DBLogger getInstance(){
		if(dbLogger == null){
			return new DBLogger();
		}
		return dbLogger;
	}
	
	public void log(String msg) {
		SessionFactory sessionFactory = createSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		LogMessage logMessage = new LogMessage(msg);
		session.save(logMessage);
		session.getTransaction().commit();
		session.close();
		System.out.println("Successfully added...");
	}
	
	public static SessionFactory createSessionFactory() {
	    Configuration configuration = new Configuration();
	    configuration.configure();
	    ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
	            configuration.getProperties()). buildServiceRegistry();
	    SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	    return sessionFactory;
	}
	
}
