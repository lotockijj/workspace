package yakov.fain.lesson22;

import java.sql.*;

class ShowAnyData {
	
	public static void main(String args[]) {
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		if (args.length==0){
			System.out.println("Usage: java ShowAnyData SQLSelectStatement");
			System.out.println("For example: java ShowAnyData \"Select * from Employee\"");
			System.exit(1);
		}
		try {
			// Class.forName(“org.apache.derby.jdbc.ClientDriver”);
			conn = DriverManager.getConnection(
					"jdbc:derby://localhost:1527/Lesson22");
						stmt = conn.createStatement();
					// Execute SQL query passed from command line
					rs = stmt.executeQuery(args[0]);
					// Find out the number of columns, their names and display the data
					ResultSetMetaData rsMeta = rs.getMetaData();
					int colCount = rsMeta.getColumnCount();
					for (int i = 1; i <= colCount; i++) {
						System.out.print(rsMeta.getColumnName(i) + " ");
					}
					System.out.println();
					while (rs.next()){
						for (int i = 1; i <= colCount; i++) {
							System.out.print(rs.getString(i) + " ");
						}
						System.out.print("\n"); // new line character
					}
		} catch( SQLException se ) {
			System.out.println ("SQLError: " + se.getMessage ()
			+ " code: " + se.getErrorCode ());
		} catch( Exception e ) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally{
			// clean up the system resources
			try{
				rs.close();
				stmt.close();
				conn.close();
			} catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}