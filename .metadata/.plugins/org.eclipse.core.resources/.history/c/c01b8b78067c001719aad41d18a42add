package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import eleks.sportclub.Client;
import eleks.sportclub.Gender;

public class DaoClientDerby {
	
	private Connection myConn;
	
	public DaoClientDerby() throws SQLException{
		myConn = DriverManager.getConnection("jdbc:derby:client;");
	}
	
	public List<Client> getAllClients(){
		List<Client> listOfClients = new ArrayList<>();
		try(Statement st = myConn.createStatement();
				ResultSet 	myRs = st.executeQuery("select *from client")){
			while(myRs.next()){
				Client tempClient = convertRowToClient(myRs);
				listOfClients.add(tempClient);
			}
		}catch (SQLException e){
			e.printStackTrace();
		}
		return listOfClients;
	}
	
	public List<Client> getClientFromName(String lastName){
		List<Client> list = new ArrayList<>();
		ResultSet myRs = null;
		try(PreparedStatement prSt = myConn.prepareStatement("select *from client "
				+ "where lastName like ?")){
			prSt.setString(1, lastName);
			myRs = prSt.executeQuery();
			while(myRs.next()){
				Client client = convertRowToClient(myRs);
				list.add(client);
			}
		} catch(SQLException e){
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
		try(PreparedStatement mySt = myConn.prepareStatement(""
				+ "insert into client(lastName, firstName, age, "
				+ "birthDate, cityName, gender, bodyBuildingWinner, startDate) values("
				+ "?, ?, ?, ?, ?, ?, ?, ?)")){
			
		 	mySt.setString(1, client.getLastName());
		 	mySt.setString(2, client.getFirstName());
		 	mySt.setInt(3, client.getAge());
		 	mySt.setDate(4, client.getBirthDate());
		 	mySt.setString(5, client.getCity());
		 	mySt.setString(6, client.getGender().toString());
		 	mySt.setBoolean(7, client.getBodybuildingWinner());
		 	mySt.setDate(8, (Date) client.getStartDate());
		 	mySt.executeUpdate();
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	public void updateClient(Client client, int id){
		try(PreparedStatement myStmt = myConn.prepareStatement("update client set lastName=?, "
				+ "firstName=?, age=?, birthDate=?, cityName=?, gender=?,  "
				+ "bodyBuildingWinner=?, startDate=? where id=?")){
			myStmt.setString(1, client.getLastName());
			myStmt.setString(2, client.getFirstName());
			myStmt.setInt(3, client.getAge());
			myStmt.setDate(4, client.getBirthDate());
			myStmt.setString(5, client.getCity());
			myStmt.setString(6, client.getGender().toString());
			myStmt.setBoolean(7, client.getBodybuildingWinner());
			myStmt.setDate(8, (Date) client.getStartDate());
			myStmt.setInt(9, id);
			
			myStmt.executeUpdate();
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	public void deleteClient(int id){
		try(PreparedStatement myStmt = myConn.prepareStatement(""
				+ "delete from client where id=?")){
			myStmt.setInt(1, id);
			myStmt.executeUpdate();
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	private Client convertRowToClient(ResultSet myRs) {
		Client client = null;
		try{
			String lastName = myRs.getString("lastName");
			String firstName = myRs.getString("firstName");
			int age = myRs.getInt("age");
			Date birthDate = myRs.getDate("birthDate");
			String cityName = myRs.getString("cityName");
			Gender gender = Gender.valueOf(myRs.getString("gender"));
			boolean bodyBuildingWinner = myRs.getBoolean("bodyBuildingWinner");
			Date startDate = myRs.getDate("startDate");
			client = new Client(lastName, firstName, age, 
					birthDate, cityName, gender, bodyBuildingWinner, startDate);
		} catch (SQLException e){
			e.printStackTrace();
		}
		return client;
	}

}