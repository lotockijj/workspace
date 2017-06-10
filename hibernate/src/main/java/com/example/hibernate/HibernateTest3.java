package com.example.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.hibernate.dto.FourWheeler;
import com.example.hibernate.dto.TwoWheeler;
import com.example.hibernate.dto.UserDetails3;
import com.example.hibernate.dto.Vehicle;

public class HibernateTest3 {

	public static void main(String[] args) {
		
		UserDetails3 userThird = new UserDetails3();
		userThird.setUserName("Trird USER");
		
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("Car");
		
		TwoWheeler bike = new TwoWheeler();
		bike.setVehicleName("Bike");
		bike.setSteeringHandle("Bike Steering Handle");
		
		FourWheeler car = new FourWheeler();
		car.setVehicleName("Porscher");
		car.setSteeringWheel("Porsche Steering Wheel");
//		vehicle.getUserList().add(userThird);
//		vehicle2.getUserList().add(userThird);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
//		session.persist(userThird);
//		session.save(vehicle);
//		session.save(vehicle2);
		session.save(vehicle);
		session.save(bike);
		
		session.getTransaction().commit();
		session.close();
		
	}

}
