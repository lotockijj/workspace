package com.example.hibernate.dto;

import javax.persistence.Embeddable;

@Embeddable
public class Address2 {
	private String street;
	private String city;
	private String state;
	private String pincode;

	public String getStreet() {
		return street;
	}
	public String getCity() {
		return city;
	}
	public String getState() {
		return state;
	}
	public String getPincode() {
		return pincode;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setState(String state) {
		this.state = state;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	
}
