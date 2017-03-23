package com.roman.my.dto;

//dto - data transfer object
public class User {
	private String userName;
	private String userId;
	
	public String getUserName() {
		return userName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
}