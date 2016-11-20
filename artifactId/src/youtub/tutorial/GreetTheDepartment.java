package youtub.tutorial;

import java.sql.*;
import java.util.Properties;

/**
 * Test calling stored procedure with INOUT parameters
 * 
 * @author www.luv2code.com
 *
 */
public class GreetTheDepartment {

	public static void main(String[] args) throws Exception {

		CallableStatement myStmt = null;
		
		Properties p = new Properties();
		p.put("user", "root");
		p.put("password", "");
		p.put("dbUrl", "jdbc:mysql://localhost:3306/userlogin");

		try (Connection myConn= DriverManager.getConnection((String)p.get("dbUrl"), p)){

			String theDepartment = "Engineering";
			
			// Prepare the stored procedure call
			myStmt = myConn
					.prepareCall("{call greet_the_department(?)}");

			// Set the parameters
			myStmt.registerOutParameter(1, Types.VARCHAR);
			myStmt.setString(1, theDepartment);

			// Call stored procedure
			System.out.println("Calling stored procedure.  greet_the_department('" + theDepartment + "')");
			myStmt.execute();
			System.out.println("Finished calling stored procedure");			
			
			// Get the value of the INOUT parameter
			String theResult = myStmt.getString(1);
			
			System.out.println("\nThe result = " + theResult);

		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

}
