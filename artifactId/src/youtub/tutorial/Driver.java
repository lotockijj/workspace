package youtub.tutorial;

import java.sql.*;
import java.util.Properties;

public class Driver {

	public static void main(String[] args) throws SQLException {

		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		Properties p = new Properties();
		p.put("user", "root");
		p.put("password", "");
		p.put("dbUrl", "jdbc:mysql://localhost:3306/userlogin");
		try (
			// 1. Get a connection to database
			Connection myCon = DriverManager.getConnection((String) p.get("dbUrl"), p)){
			
			// 2. Prepare statement
			myStmt = myCon.prepareStatement("select * from enterprise where salary > ? and department=?");
			
			// 3. Set the parameters
			myStmt.setDouble(1, 80000);
			myStmt.setString(2, "Legal");
			
			// 4. Execute SQL query
			myRs = myStmt.executeQuery();
			
			// 5. Display the result set
			display(myRs);
		
			//
			// Reuse the prepared statement:  salary > 25000,  department = HR
			//

			System.out.println("\n\nReuse the prepared statement:  salary > 25000,  department = HR");
			
			// 6. Set the parameters
			myStmt.setDouble(1, 25000);
			myStmt.setString(2, "HR");
			
			// 7. Execute SQL query
			myRs = myStmt.executeQuery();
			
			// 8. Display the result set
			display(myRs);
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	private static void display(ResultSet myRs) throws SQLException {
		while (myRs.next()) {
			String lastName = myRs.getString("last_name");
			String firstName = myRs.getString("first_name");
			double salary = myRs.getDouble("salary");
			String department = myRs.getString("department");
			
			System.out.printf("%s, %s, %.2f, %s\n", lastName, firstName, salary, department);
		}
	}
}
