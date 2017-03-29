package com.example.hibernate.dto;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USER_DETAILS2")
public class UserDetails2 {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	private String userName;
	@ElementCollection
	private Set<Address2> listOfAddresses = new HashSet<Address2>();
	
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
	public Set<Address2> getListOfAddresses() {
		return listOfAddresses;
	}
	public void setListOfAddresses(Set<Address2> listOfAddresses) {
		this.listOfAddresses = listOfAddresses;
	}
	
}
