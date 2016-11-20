package main.java.faberlic;

import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.jdbc.Statement;

public class DriverDB {
	
	public static void main(String[] args) {
		
		Properties p = new Properties();
		p.put("user", "root");
		p.put("password", "");
		//p.put("dbUrl", "jdbc:mysql://localhost:3306/my_new_data_base?useUnicode=yes&characterEncoding=UTF-8");
		p.put("dbUrl", "jdbc:mysql://localhost:3306/my_new_data_base?zeroDateTimeBehavior=convertToNull");
		try(Connection myConn = DriverManager.getConnection((String) p.get("dbUrl"), p)){
			Statement myStmt = (Statement) myConn.createStatement();
			ResultSet myRs = myStmt.executeQuery("select *from faberlic_goods");
			while(myRs.next()){
				System.out.println(myRs.getString("ID") + ". " +
			myRs.getString("NAME") + ", " + myRs.getString("ARTICLE") + ", " +
			myRs.getString("AMOUNT") + ", " + myRs.getString("DATE_PRODUCTION") + ", " +
			myRs.getString("EXPIRATION_DATE") + ", " + myRs.getString("END_DATE"));
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

}
