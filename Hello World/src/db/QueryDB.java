package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class QueryDB {

	public final String SQL_STATEMENT = "select * from channels";
	public final String JDBC_URL = "jdbc:derby:zadb;create=true";
	ResultSet resSet = null; 
	public void createQuery(){

		try(Connection conn = DriverManager.getConnection(JDBC_URL)){
			Statement stmt = conn.createStatement();
			resSet = stmt.executeQuery(SQL_STATEMENT);
			ResultSetMetaData resSetMetaData = resSet.getMetaData();
			int columnCount = resSetMetaData.getColumnCount();
			for(int i = 1; i <= columnCount; i++){
				System.out.format("%20s", resSetMetaData.getColumnName(i) + " | ");
			}
			while(resSet.next()){
				System.out.println();
				for(int i = 1; i <= columnCount; i++){
					System.out.format("%20s", resSet.getString(i) + " | ");
				}
			}
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			try {
				if(resSet != null) resSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
