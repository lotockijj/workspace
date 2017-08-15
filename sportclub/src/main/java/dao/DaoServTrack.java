package dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import tracks.ServicesTrack;

public class DaoServTrack {
	private Connection myConn;
	
	public DaoServTrack() throws FileNotFoundException, IOException, SQLException{
		Properties props = new Properties();
		props.load(new FileInputStream("demo.properties"));
		String user = props.getProperty("user");
		String password = props.getProperty("password");
		String dburl = props.getProperty("dburl");
		myConn = DriverManager.getConnection(dburl, user, password);
	}
	
	 //takeGeneralMassage;takeSolyariy;takeKrosfit;takeYoga;numberVisitsMonthly;
	public void updateServicesTrack(ServicesTrack track, int id){
		try(PreparedStatement myStmt = myConn.prepareStatement("update servicesTrack "
				+ "set takeGeneralMassage=?, takeSolyariy=?, takeKrosfit=?, "
				+ "takeYoga=?, numberVisitsMonthly=? where id=?;")){
			myStmt.setBoolean(1, track.isTakeGeneralMassage());
			myStmt.setBoolean(2, track.isTakeSolyariy());
			myStmt.setBoolean(3, track.isTakeKrosfit());
			myStmt.setBoolean(4, track.isTakeYoga());
			myStmt.setInt(5, track.getNumberVisitsMonthly());
			myStmt.setInt(6, id);
			myStmt.executeUpdate();
		}catch (SQLException e){
			e.printStackTrace();
		}
	}
}
