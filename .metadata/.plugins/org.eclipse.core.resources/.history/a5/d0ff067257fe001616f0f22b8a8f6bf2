package gui;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class AuditHistoryDAO {
	private Connection myConn;

	public AuditHistoryDAO() throws FileNotFoundException, IOException, SQLException{
		Properties props = new Properties();
		props.load(new FileInputStream("demo.properties"));
		String user = props.getProperty("user");
		String password = props.getProperty("password");
		String dburl = props.getProperty("dburl");
		myConn = DriverManager.getConnection(dburl, user, password);
		System.out.println("DB connection successful to: " + dburl);
	}
	
	public List<UsersHistory> getTheWholeAuditHistory(){
		List<UsersHistory> list = new ArrayList<>();
		try(Statement myStmt = myConn.createStatement();
				ResultSet 	myRs = myStmt.executeQuery("select *from audit_history;")){
			while(myRs.next()){
				UsersHistory tempGoods = convertRowToAuditHistory(myRs);
				list.add(tempGoods);
			}
		} catch(Exception e){
			AlertGui.createAlertError(e);
		}
		return list;
	}

	private UsersHistory convertRowToAuditHistory(ResultSet myRs) {
		UsersHistory tempUsersHistory = new UsersHistory();
		try{
			int id = myRs.getInt("id");
			String last_name = myRs.getString("last_name");
			String first_name = myRs.getString("first_name");
			String action = myRs.getString("action");
			Date actionDateTime = myRs.getDate("action_date_time");
			tempUsersHistory = new UsersHistory(id, last_name, first_name, action, actionDateTime);
		} catch (SQLException e){
			AlertGui.createAlertError(e);
		}
		return tempUsersHistory;
	}
}
