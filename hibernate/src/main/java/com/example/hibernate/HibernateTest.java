package com.example.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.hibernate.dto.Address;
import com.example.hibernate.dto.Address2;
import com.example.hibernate.dto.UserDetails;
import com.example.hibernate.dto.UserDetails2;

public class HibernateTest {
	
	public static void main(String[] args) {
		
//		UserDetails user = new UserDetails();
//		// @GenerateValue in UserDetail eliminate user.setUserId(1);
//		user.setUserName("First User");
//		Address address = createAddress("Avenu 1", "New Yourk", "NY", "1111");
//		Address address2 = createAddress("Avenu office", "Washington", "WA", "3333");
//		user.setHomeAddress(address);
//		user.setOfficeAddress(address2);
//		user.setJoinedDate(new Date());
//		user.setDescription("Description of the user goes here");
//		
//		UserDetails user2 = new UserDetails();
//		user2.setUserName("Second user");
//		address = createAddress("Avenu 2", "Boston", "TX", "2222");
//		address2 = createAddress("Avenu office2", "Texas", "TX", "4444");
//		user2.setHomeAddress(address);
//		user2.setOfficeAddress(address2);
//		user2.setJoinedDate(new Date());
//		user2.setDescription("Description of the user2 goes here!!!" );
//		
//		UserDetails2 userSecond = new UserDetails2();
//		userSecond.setUserName("Third user");
//		Address2 addr11 = createAddress2("Avenu II", "Belz", "Lviv", "79000");
//		Address2 addr22 = createAddress2("Avenu III", "Yavoriv", "Lviv", "89000");
//		userSecond.getListOfAddresses().add(addr11);
//		userSecond.getListOfAddresses().add(addr22);
//		
//		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
//		Session session = sessionFactory.openSession();
//		session.beginTransaction();
//		session.save(user);
//		session.save(user2);
//		session.save(userSecond);
//		session.getTransaction().commit();
//		session.close();
//		
//		user = null;
//		session = sessionFactory.openSession();
//		session.beginTransaction();
//		user = (UserDetails) session.get(UserDetails.class, 1);
//		System.out.println("User name is " + user.getUserName());
//		
//		userSecond = (UserDetails2) session.get(UserDetails2.class, 3);
//		System.out.println("The list of addresses contains: " 
//					+ userSecond.getListOfAddresses().size() + " records.");
//		session.close();
	}

	private static Address createAddress(String street, String city, String state, String pincode) {
		Address address = new Address();
		address.setStreet(street);
		address.setCity(city);
		address.setState(state);
		address.setPincode(pincode);
		return address;
	}

	private static Address2 createAddress2(String street, String city, String state, String pincode) {
		Address2 address = new Address2();
		address.setStreet(street);
		address.setCity(city);
		address.setState(state);
		address.setPincode(pincode);
		return address;
	}
}
