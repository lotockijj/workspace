package youtub.tutorial;

import java.sql.*;

/**
 * Test calling stored procedure with IN parameters
 *  
 * @author www.luv2code.com
 *
 */
public class IncreaseSalariesForDepartment {

	public static void main(String[] args) throws Exception {

		CallableStatement myStmt = null;

		try (Connection myConn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/demo", "student", "YES")){

			String theDepartment = "Engineering";
			int theIncreaseAmount = 10000;
			
			// Show salaries BEFORE
			System.out.println("Salaries BEFORE\n");
			showSalaries(myConn, theDepartment);

			// Prepare the stored procedure call
			myStmt = myConn
					.prepareCall("{call increase_salaries_for_department(?, ?)}");

			// Set the parameters
			myStmt.setString(1, theDepartment);
			myStmt.setDouble(2, theIncreaseAmount);

			// Call stored procedure
			System.out.println("\n\nCalling stored procedure.  increase_salaries_for_department('" + theDepartment + "', " + theIncreaseAmount + ")");
			myStmt.execute();
			System.out.println("Finished calling stored procedure");

			// Show salaries AFTER
			System.out.println("\n\nSalaries AFTER\n");
			showSalaries(myConn, theDepartment);

		} catch (Exception exc) {
			exc.printStackTrace();
		} 
	}

	private static void showSalaries(Connection myConn, String theDepartment) throws SQLException {
		ResultSet myRs = null;

		try (PreparedStatement myStmt = myConn
					.prepareStatement("select * from employees where department=?")){

			myStmt.setString(1, theDepartment);
			
			// Execute SQL query
			myRs = myStmt.executeQuery();

			// Process result set
			while (myRs.next()) {
				String lastName = myRs.getString("last_name");
				String firstName = myRs.getString("first_name");
				double salary = myRs.getDouble("salary");
				String department = myRs.getString("department");
				
				System.out.printf("%s, %s, %s, %.2f\n", lastName, firstName, department, salary);
			}
		} catch (Exception exc) {
			exc.printStackTrace();
		} 
	}

}