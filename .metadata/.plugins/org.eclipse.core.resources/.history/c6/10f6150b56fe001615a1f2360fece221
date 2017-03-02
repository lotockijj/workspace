package com.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import gui.AlertGui;
import gui.User;

public class UserDAO { // Data Access Object

	private Connection myConn;

	public UserDAO() throws FileNotFoundException, IOException, SQLException{
		Properties props = new Properties();
		props.load(new FileInputStream("demo.properties"));
		String user = props.getProperty("user");
		String password = props.getProperty("password");
		String dburl = props.getProperty("dburl");
		myConn = DriverManager.getConnection(dburl, user, password);
		System.out.println("DB connection successful to: " + dburl);
	}
	
	public List<User> getAllUsers(){
		List<User> list = new ArrayList<>();
		try(Statement myStmt = myConn.createStatement();
				ResultSet 	myRs = myStmt.executeQuery("select *from users;")){
			while(myRs.next()){
				User tempGoods = convertRowToUser(myRs);
				list.add(tempGoods);
			}
		} catch(Exception e){
			AlertGui.createAlertError(e);
		}
		return list;
	}

	private User convertRowToUser(ResultSet myRs) {
		User tempUser = new User();
		try{
			int id = myRs.getInt("id");
			String last_name = myRs.getString("last_name");
			String first_name = myRs.getString("first_name");
			String email = myRs.getString("email");
			String password = myRs.getString("password");
			tempUser = new User(id, last_name, first_name, email, password);
		} catch (SQLException e){
			AlertGui.createAlertError(e);
		}
		return tempUser;
	}
}
