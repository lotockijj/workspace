package main.java.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class ShowAnyData {
	
	public static void main(String[] args) throws SQLException {
		Statement stmt = null;
		ResultSet rs = null;
		
		Properties p = new Properties();
		p.put("user", "root");
		p.put("password", "");
		p.put("dbUrl", "jdbc:mysql://localhost:3306/ENTERPRISE");
		
		if(args.length == 0){
			System.out.println("Usage: java ShowAnyData SQLSelectStatement");
			System.exit(1);
		}
		try(Connection myCon = DriverManager.getConnection((String)p.get("dbUrl"), p)){
			stmt = myCon.createStatement();
			rs = stmt.executeQuery(args[0]);
			System.out.println(args[0]);
			
			ResultSetMetaData rsMeta = rs.getMetaData();
			int colCount = rsMeta.getColumnCount();
			for(int i = 1; i <= colCount; i++){
				System.out.print(rsMeta.getColumnName(i) + " ");
			}
			System.out.println();
			while(rs.next()){
				for(int i = 1; i <= colCount; i++){
					System.out.print(rs.getString(i) + " ");
				}
				System.out.print("\n");
			}
			System.out.println();
			rs.afterLast();
			while(rs.previous()){
				for(int i = 1; i <= colCount; i++){
					System.out.print(rs.getString(i) + " ");
				}
				System.out.print("\n");
			}
//			You can also move the cursor to a specifc row by using the following self-explanatory methods:
//				rs.absolute(25); // moves the cursor to the 25th row
//				rs.relative(-4); // moves the cursor to the 21st row
//				rs.first();
//				rs.last();
//				rs.beforeFirst();
		} catch (SQLException e){
			System.out.println("SQLError: " + e.getMessage());
		} catch (Exception e1){
			System.out.println(e1.getMessage());
			e1.printStackTrace();
		}
	}

}
