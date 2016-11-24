package src.com.luv2code.jdbc.employeesearch.dao;

import java.util.*;
import java.sql.*;
import java.io.*;
import java.math.BigDecimal;

import src.com.luv2code.jdbc.employeesearch.core.Employee;

public class EmployeeDAO {

	private Connection myConn;

	public EmployeeDAO() throws Exception {

		// get db properties
		Properties props = new Properties();
		props.load(new FileInputStream("c:\\Users\\Роман Лотоцький\\workspace\\artifactId\\src\\src\\com\\luv2code\\jdbc\\employeesearch\\core\\demo.properties"));

		String user = props.getProperty("user");
		String password = props.getProperty("");
		String dburl = props.getProperty("dburl");

		// connect to database
		myConn = DriverManager.getConnection(dburl, user, password);

		System.out.println("DB connection successful to: " + dburl);
	}

	public List<Employee> getAllEmployees() throws Exception {
		List<Employee> list = new ArrayList<>();

		Statement myStmt = null;
		ResultSet myRs = null;

		try {
			myStmt = myConn.createStatement();
			myRs = myStmt.executeQuery("select * from enterprise");

			while (myRs.next()) {
				Employee tempEmployee = convertRowToEmployee(myRs);
				list.add(tempEmployee);
			}

			return list;		
		}
		finally {
			close(myStmt, myRs);
		}
	}

	public List<Employee> searchEmployees(String lastName) throws Exception {
		List<Employee> list = new ArrayList<>();

		PreparedStatement myStmt = null;
		ResultSet myRs = null;

		try {
			lastName += "%";
			myStmt = myConn.prepareStatement("select * from enterprise where last_name like ?");

			myStmt.setString(1, lastName);

			myRs = myStmt.executeQuery();

			while (myRs.next()) {
				Employee tempEmployee = convertRowToEmployee(myRs);
				list.add(tempEmployee);
			}

			return list;
		}
		finally {
			close(myStmt, myRs);
		}
	}

	private Employee convertRowToEmployee(ResultSet myRs) throws SQLException {

		int id = myRs.getInt("id");
		String lastName = myRs.getString("last_name");
		String firstName = myRs.getString("first_name");
		String email = myRs.getString("email");
		BigDecimal salary = myRs.getBigDecimal("salary");

		Employee tempEmployee = new Employee(id, lastName, firstName, email, salary);

		return tempEmployee;
	}

	private void showAllColumnNames() throws SQLException{
		ResultSet myRs = null;
		try{
			PreparedStatement myStmt = myConn.prepareStatement("select * from enterprise");
			myRs = myStmt.executeQuery();
			ResultSetMetaData metaData = myRs.getMetaData();

			int columnCount = metaData.getColumnCount();
			System.out.println(columnCount);
			for (int i = 1; i <= columnCount; i++) {
				System.out.println(metaData.getColumnLabel(i));
			}
		} catch (SQLException e){
			System.out.println(e);
		} finally {
			myConn.close();
			myRs.close();
		}
	}

	private static void close(Connection myConn, Statement myStmt, ResultSet myRs)
			throws SQLException {

		if (myRs != null) {
			myRs.close();
		}

		if (myStmt != null) {

		}

		if (myConn != null) {
			myConn.close();
		}
	}

	private void close(Statement myStmt, ResultSet myRs) throws SQLException {
		close(null, myStmt, myRs);		
	}

	public static void main(String[] args) throws Exception {

		EmployeeDAO dao = new EmployeeDAO();
		System.out.println(dao.searchEmployees("Public"));

		System.out.println(dao.getAllEmployees());
		dao.showAllColumnNames();
	}
}
