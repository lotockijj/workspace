package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import tracks.ServicesTrack;

public class DaoServicesTrack {
	private Connection myConn;
	
	public DaoServicesTrack() throws SQLException{
		myConn = DriverManager.getConnection("jdbc:derby:client;");
	}
	
	public List<ServicesTrack> getAllServices(){
		List<ServicesTrack> listOfServices = new ArrayList<>();
		try(Statement st = myConn.createStatement();
				ResultSet 	myRs = st.executeQuery("select *from servicesTrack")){
			while(myRs.next()){
				ServicesTrack tempClient = convertRowToServiceTrack(myRs);
				listOfServices.add(tempClient);
			}
		}catch (SQLException e){
			e.printStackTrace();
		}
		return listOfServices;
	}
	
	public void getClientFromName(String serchingName){
		ResultSet myRs = null;
		try(PreparedStatement prSt = myConn.prepareStatement("select * "
				+ "from client "
				+ "join servicesTrack "
				+ "on client.id = servicesTrack.id "
				+ "where firstName=?")){
			System.out.println("something");
			prSt.setString(1, serchingName);
			myRs = prSt.executeQuery();
			while(myRs.next()){
				String lastName = myRs.getString("lastName");
				String firstName = myRs.getString("firstName");
				boolean takeGeneralMassage = myRs.getBoolean("takeGeneralMassage");
				System.out.println(lastName + " " + firstName + " " + takeGeneralMassage);
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
	}
	 
	public void addService(ServicesTrack service){
		try(PreparedStatement mySt = myConn.prepareStatement(""
				+ "insert into servicesTrack(takeGeneralMassage, takeSolyariy, takeKrosfit, "
				+ "takeYoga, numberVisitsMonthly) values("
				+ "?, ?, ?, ?, ?)")){
			mySt.setBoolean(1, service.isTakeGeneralMassage());
			mySt.setBoolean(2, service.isTakeSolyariy());
			mySt.setBoolean(3, service.isTakeKrosfit());
			mySt.setBoolean(4, service.isTakeYoga());
			mySt.setInt(5, service.getNumberVisitsMonthly());
		 	mySt.executeUpdate();
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	 
	public void updateClient(ServicesTrack service, int id){
		try(PreparedStatement myStmt = myConn.prepareStatement("update servicesTrack set "
				+ "takeGeneralMassage=?, takeSolyariy=?, takeKrosfit=?, "
				+ "takeYoga=?, numberVisitsMonthly=? where id=?")){
			myStmt.setBoolean(1, service.isTakeGeneralMassage());
			myStmt.setBoolean(2, service.isTakeSolyariy());
			myStmt.setBoolean(3, service.isTakeKrosfit());
			myStmt.setBoolean(4, service.isTakeYoga());
			myStmt.setInt(5, service.getNumberVisitsMonthly());
			myStmt.setInt(6, id);
			myStmt.executeUpdate();
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	public void deleteClient(int id){
		try(PreparedStatement myStmt = myConn.prepareStatement(""
				+ "delete from servicesTrack where id=?")){
			myStmt.setInt(1, id);
			myStmt.executeUpdate();
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	private ServicesTrack convertRowToServiceTrack(ResultSet myRs) {
		ServicesTrack service = null;
		try{
			boolean takeGeneralMassage = myRs.getBoolean("takeGeneralMassage");
			boolean takeSolyariy = myRs.getBoolean("takeSolyariy");
			boolean takeKrosfit = myRs.getBoolean("takeKrosfit");
			boolean takeYoga = myRs.getBoolean("takeYoga");
			int numberVisitsMonthly = myRs.getInt("numberVisitsMonthly");
			service = new ServicesTrack(takeGeneralMassage, takeSolyariy, 
					takeKrosfit, takeYoga, numberVisitsMonthly);
		} catch (SQLException e){
			e.printStackTrace();
		}
		return service;
	}

}