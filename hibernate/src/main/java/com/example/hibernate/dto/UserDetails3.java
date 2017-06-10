package com.example.hibernate.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="USER_DETAILS_3")
public class UserDetails3 {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	private String userName;
	
//	@OneToOne
//	@JoinColumn(name="VEHICLE_ID")
//	@OneToMany(mappedBy="user")
//	@JoinTable(name="USER_VEHICLE",
//			   joinColumns=@JoinColumn(name="User_ID"), 
//		       inverseJoinColumns=@JoinColumn(name="VEHICLE_ID")
//	)
	@OneToMany(cascade=CascadeType.PERSIST)
	private Collection<Vehicle> vehicle = new ArrayList<Vehicle>();
	
	public Collection<Vehicle> getVehicle() {
		return vehicle;
	}
	public void setVehicle(Collection<Vehicle> vehicle) {
		this.vehicle = vehicle;
	}
	public int getUserId() {
		return userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
