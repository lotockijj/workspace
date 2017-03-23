package com.roman.my.service;

import java.util.HashMap;

import com.roman.my.dto.User;

public class LoginService {
	HashMap<String, String> users;
	
	public LoginService(){
		users = new HashMap<>();
		users.put("roman", "roman");
		users.put("nataly", "nataly");
		users.put("kolya", "kolya");
	}
	
	public boolean authenticate(String userId, String password){
		if(password == null || password == ""){
			return false;
		}
		return true;
	}
	
	public User getUserDetails(String userId){
		User user = new User();
		user.setUserName(users.get(userId));
		user.setUserId(userId);
		return user;
	}
}
