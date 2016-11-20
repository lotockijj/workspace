package main.java.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Properties;

import com.mysql.jdbc.Statement;

public class Driver {
	
	public static void main(String[] args) {
		try{
		//1.Get a connection to database;
			Properties p = new Properties();
			p.put("user", "root");
			p.put("password", "");
			p.put("dbUrl", "jdbc:mysql://localhost:3306/my_new_data_base");
		Connection myConn = DriverManager.getConnection((String) p.get("dbUrl"), p);
		// 2.Create a statement
		Statement myStmt = (Statement) myConn.createStatement();
		//3. Execute SQL query
		ResultSet myRs = myStmt.executeQuery("select * from GOODS");
		// 4.Process the result set
		while(myRs.next()){
			System.out.println(myRs.getString("NAME") + ", " + myRs.getString("FABERLIC_NUMBER"));
		}
		} catch (Exception e){
			e.printStackTrace();
		}
	
	}

}
