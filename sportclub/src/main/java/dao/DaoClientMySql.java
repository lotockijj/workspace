package dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import eleks.sportclub.Client;
import eleks.sportclub.Gender;

public class DaoClientMySql {

	private Connection myConn;
	
	public DaoClientMySql() throws SQLException, FileNotFoundException, IOException{
		Properties props = new Properties();
		props.load(new FileInputStream("demo.properties"));
		String user = props.getProperty("user");
		String password = props.getProperty("password");
		String dburl = props.getProperty("dburl");
		//connect to database
		myConn = DriverManager.getConnection(dburl, user, password);
		//System.out.println("DB connection successful to: " + dburl);
	}

	public List<Client> getAllGoods(){
		List<Client> list = new ArrayList<>();
		try(Statement myStmt = myConn.createStatement();
				ResultSet myRs = myStmt.executeQuery("select *from client;")){
			while(myRs.next()){
				Client tempGoods = convertRowToGoods(myRs);
				list.add(tempGoods);
			}
		} catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Client> searchClient(String lastName){
		List<Client> list = new ArrayList<>();
		ResultSet myRs = null;
		lastName += "%";
		try(PreparedStatement myStmt = myConn.prepareStatement("select *from client "
				+ "where lastName like ?;")){
			myStmt.setString(1, lastName);
			myRs = myStmt.executeQuery();
			while(myRs.next()){
				Client client = convertRowToGoods(myRs);
				list.add(client);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				myRs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public void addClient(Client client){
		try(PreparedStatement myStmt = myConn.prepareStatement("insert into client ("
				+ "lastName, firstName, age, birthDate, city, gender, "
				+ "bodyBuildingWinner, startDate) "
				+ "values(?, ?, ?, ?, ?, ?, ?, ?);")){

			myStmt.setString(1, client.getLastName());
			myStmt.setString(2, client.getFirstName());
			myStmt.setInt(3, client.getAge());
			myStmt.setDate(4, client.getBirthDate());
			myStmt.setString(5, client.getCity());
			myStmt.setString(6, client.getGender().toString());
			myStmt.setBoolean(7, client.getBodybuildingWinner());
			myStmt.setDate(8, client.getStartDate());
			myStmt.executeUpdate();
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	public void updateClient(Client client, int id){
		try(PreparedStatement myStmt = myConn.prepareStatement("update client set lastName=?, "
				+ "firstName=?, age=?, birthDate=?, city=?, gender=?, "
				+ "bodyBuildingWinner=?, startDate=? where id=?;")){
			myStmt.setString(1, client.getLastName());
			myStmt.setString(2, client.getFirstName());
			myStmt.setInt(3, client.getAge());
			myStmt.setDate(4, client.getBirthDate());
			myStmt.setString(5, client.getCity());
			myStmt.setString(6, client.getGender().toString());
			myStmt.setBoolean(7, client.getBodybuildingWinner());
			myStmt.setDate(8, client.getStartDate());
			myStmt.setInt(9, id);

			myStmt.executeUpdate();
		} catch (SQLException e){
			e.printStackTrace();
		}
	}

	public void deleteClient(int id){
		try(PreparedStatement myStmt = myConn.prepareStatement(""
				+ "delete from client where id=?;")){
			myStmt.setInt(1, id);
			myStmt.executeUpdate();
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	private Client convertRowToGoods(ResultSet myRs) {
		Client tempClient = new Client();
		try{
			String lastName = myRs.getString("lastName");
			String firstName = myRs.getString("firstName");
			int age = myRs.getInt("age");
			Date birthDate = myRs.getDate("birthDate");
			String city = myRs.getString("city");
			Gender gender = Gender.valueOf(myRs.getString("gender"));
			boolean bodyBuildingWinner = myRs.getBoolean("bodyBuildingWinner");
			Date startDate = myRs.getDate("startDate");

			tempClient = new Client(lastName, firstName, age, birthDate, city, gender,
					bodyBuildingWinner, startDate);
		} catch (SQLException e){
			e.printStackTrace();
		}
		return tempClient;
	}
	
}
