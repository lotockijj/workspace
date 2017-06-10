package com.example.hibernate.crud;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class HibernateTest {

	public static void main(String[] args) {


		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

//		for(int i = 0; i < 10; i++){
//			UserDetails5 user = new UserDetails5();
//			user.setUserName("User " + (i + 1));
//			session.save(user);
//		}
		//System.out.println(user.getUserName());
		//session.delete(user);
		//user.setUserName("Updated user name");
		//session.update(user);
//		UserDetails5 user = new UserDetails5(); 
//		user.setUserName("Test user");
//		session.save(user);
//		// transient, persistent, detouched!!! :) 
//		user.setUserName("Updated user");
		
//		UserDetails5 user = (UserDetails5) session.get(UserDetails5.class, 1);
//		session.getTransaction().commit();
//		session.close();
		
		//user.setUserName("Updated user name after session close! :) ");
		
		session = sessionFactory.openSession();
		session.beginTransaction();
		//session.update(user);
		//user.setUserName("Change after update");
		
		String minUserId = "6";
		String userName = "User 10";
		
//		Query query = session.createQuery("from UserDetails5 where userId > ? and userName = ?");
//		query.setInteger(0, Integer.parseInt(minUserId));
//		query.setString(1, userName);
		Query query = session.createQuery("from UserDetails5 "
				+ "where userId > :userId and :userName = userName");
		query.setInteger("userId", Integer.parseInt(minUserId));
		query.setString("userName", userName);
		Query query2 = session.getNamedQuery("UserDetails5.byId");
		query2.setInteger(0, 2);
		Query query3 = session.getNamedQuery("UserDetails5.byName");
		query3.setString(0, "User 10");
//		query.setFirstResult(5);
//		query.setMaxResults(2);
		List<UserDetails5> users = (List<UserDetails5>) query.list();
		List<UserDetails5> user2 = (List<UserDetails5>) query2.list();
		List<UserDetails5> user3 = (List<UserDetails5>) query3.list();
		//List<String> userName = (List<String>) query.list();
		
		Criteria criteria = session.createCriteria(UserDetails5.class);
		criteria.add(Restrictions.eq("userName", "User 10"))
				.add(Restrictions.gt("userId", 5))
				.add(Restrictions.between("userId", 5, 10));
		List<UserDetails5> user4 = (List<UserDetails5>) criteria.list();
		
		Criteria criteria2 = session.createCriteria(UserDetails5.class);
		criteria2.add(Restrictions.or(Restrictions.between("userId", 3, 5), 
									  Restrictions.like("userName", "User 7")));
		List<UserDetails5> user5 = (List<UserDetails5>) criteria2.list();
		
		Criteria criteria3 = session.createCriteria(UserDetails5.class)
				.setProjection(Projections.property("userId"));
				//.setProjection(Projections.count("userId"))
				//.addOrder(Order.desc("userId"));
		
		//List<UserDetails5> user6 = (List<UserDetails5>) criteria3.list();
		List<Integer> user61 = (List<Integer>) criteria3.list();
		
		UserDetails5 exampleUser = new UserDetails5();
		exampleUser.setUserId(5);
		exampleUser.setUserName("User 5");
		
		Example example = Example.create(exampleUser);
		
		Criteria criteria7 = session.createCriteria(UserDetails5.class)
				.add(example);
		List<UserDetails5> user7 = (List<UserDetails5>) criteria7.list();
		session.getTransaction().commit();
		session.close();
		writeList(users);
		writeList(user2);
		writeList(user3);
		writeList(user4);
		writeList(user5);
		writeList(user7);
		//writeList(user6);
		for(int i : user61){
			System.out.print(i + ", ");
		}
	}

	private static void writeList(List<UserDetails5> users) {
		for(UserDetails5 user : users){
			System.out.println("Criteria is: " + user.getUserName() + ", id: " + user.getUserId());
		}
		System.out.println("*********************************");
	}

}
