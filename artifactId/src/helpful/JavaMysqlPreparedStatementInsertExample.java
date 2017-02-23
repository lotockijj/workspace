package helpful;

import java.sql.*;
import java.util.Calendar;
import java.util.Properties;

/**
 * A Java MySQL PreparedStatement INSERT example.
 * Demonstrates the use of a SQL INSERT statement against a
 * MySQL database, called from a Java program, using a
 * Java PreparedStatement.
 */
public class JavaMysqlPreparedStatementInsertExample{

	public static void main(String[] args){
		Properties p = new Properties();
		p.put("user", "root");
		p.put("password", "");
		p.put("dbUrl", "jdbc:mysql://localhost:3306/my_new_data_base");
		try(Connection conn = DriverManager.getConnection((String) p.get("dbUrl"), p)){

			// create a sql date object so we can use it in our INSERT statement
			Calendar calendar = Calendar.getInstance();
			java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());

			// the mysql insert statement
			String query = " insert into users (first_name, last_name, date_created, is_admin, num_points)"
					+ " values (?, ?, ?, ?, ?)";

			// create the mysql insert preparedstatement
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString (1, "Barney");
			preparedStmt.setString (2, "Rubble");
			preparedStmt.setDate   (3, startDate);
			preparedStmt.setBoolean(4, false);
			preparedStmt.setInt    (5, 5000);

			// execute the preparedstatement
			preparedStmt.execute();
		}catch (Exception e){
			System.err.println("Got an exception!");
			System.err.println(e.getMessage());
		}
	}
}