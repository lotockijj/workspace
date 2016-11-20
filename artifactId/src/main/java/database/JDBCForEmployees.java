package main.java.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.sql.ResultSetMetaData;

public class JDBCForEmployees {

	public static void main(String[] args) {
		
		Properties p = new Properties();
		p.put("user", "root");
		p.put("password", "");
		p.put("dbUrl", "jdbc:mysql://localhost:3306/userlogin");
		try(Connection myCon = DriverManager.getConnection((String)p.get("dbUrl"), p)){
			Statement myStmt = myCon.createStatement();
			ResultSet myRs = myStmt.executeQuery("select * from employees");
			String sql = "insert into employees "
					+ " (id, last_name, first_name, email) "
					+ "values (6, 'Brown', 'David', 'david.brown@foo.com')"; 
			//myStmt.executeUpdate(sql);
//			System.out.println("Insert complete.");
//			String sql2 = "update employees " +
//			" set email='demo@luv2code.com' " +
//			" where id=6";
//			//myStmt.executeUpdate(sql2);
//			System.out.println("Update complete. ");
//			String sql3 = "delete from employees where email='david.brown@foo.com'";
//			int rowsAffected = myStmt.executeUpdate(sql3);
//			System.out.println("Rows affected: " + rowsAffected);

			ResultSetMetaData rsMeta = myRs.getMetaData();
			int colCount = rsMeta.getColumnCount();
			for(int i = 1; i <= colCount; i++){
				System.out.println(
						" Column name: " + rsMeta.getColumnName(i) + 
						" Column type: " + rsMeta.getColumnTypeName(i));
			}
			System.out.println("*** ResultSetMetaData COMPLETE ***");
		} catch (SQLException e){
			System.out.println(e);
		}
		
	}

}
