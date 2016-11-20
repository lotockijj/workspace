package main.java.database;


import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.mysql.jdbc.Connection;

public class Main {

	public static void main( String[] args ) throws Exception{
		createTable();
	}

	public static void createTable() throws Exception{
		try{
			Connection con = getConnection();
			PreparedStatement create = (PreparedStatement) con.prepareStatement("CREATE TABLE IF NOT EXISTS tablename(id int NOT NULL AUTO_INCREMENT, first varchar(255), last varchar(255), PRIMARY KEY(id))");
			create.executeUpdate();

		} catch (Exception e){
			System.out.println(e);
		} 
		finally {
			System.out.println("Function complete. ");

		}
	}

	public static Connection getConnection() throws Exception{
		try{
			String driver = "com.mysql.jdbs.Driver";
			String url = "jdbs:mysql://localhost:3306/database";
			String userName = "hey";
			String password = "mypass";
			Class.forName(driver);
			Connection conn = (Connection) DriverManager.getConnection(url, userName, password);
			System.out.println("Connected.");
			return conn; 
		} catch(Exception e){
			System.out.println(e);
		}
		return null; 
	}
}
