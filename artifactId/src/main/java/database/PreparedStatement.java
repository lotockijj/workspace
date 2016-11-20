package main.java.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class PreparedStatement {
	
	public static void main(String[] args) throws SQLException {
		
		java.sql.PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		Properties p = new Properties();
		p.put("user", "root");
		p.put("password", "");
		p.put("dbUrl", "jdbc:mysql://localhost:3306/userlogin");
		
		try(Connection myConn = 
				DriverManager.getConnection((String)p.get("dbUrl"), p)){
			myStmt = myConn
					.prepareStatement("select * from enterprise where salary > ? and department = ?");
			myStmt.setDouble(1, 75000);
			myStmt.setString(2, "Legal");
			myRs = myStmt.executeQuery();
			display(myRs);
			
			// reuse prepared statement: 
			// we can also use it for insert, delete, update.
			
			System.out.println();
			myStmt.setInt(1, 25000);
			myStmt.setString(2, "HR");
			myRs = myStmt.executeQuery();
			display(myRs);
		} 
	}

	private static void display(ResultSet myRs) throws SQLException {
		while(myRs.next()){
			System.out.println(myRs.getString("id") + ". " + myRs.getString("last_name") + ", " 
		+ myRs.getString("first_name") + ", " + myRs.getString("salary") + ", "
		+ myRs.getString("department"));
		}
		
	}

}
