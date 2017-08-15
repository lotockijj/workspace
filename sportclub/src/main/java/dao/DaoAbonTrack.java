package dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import tracks.AbonnementsTrack;

public class DaoAbonTrack {
	private Connection myConn;

	public DaoAbonTrack() throws FileNotFoundException, IOException, SQLException{
		Properties props = new Properties();
		props.load(new FileInputStream("demo.properties"));
		String user = props.getProperty("user");
		String password = props.getProperty("password");
		String dburl = props.getProperty("dburl");
		myConn = DriverManager.getConnection(dburl, user, password);
	}

	//base;baseAllDay;baseUnlimited;baseAllDayUnlimited;personalCoach;
	public void updateAbonnementsTrack(AbonnementsTrack track, int id){
		try(PreparedStatement myStmt = myConn.prepareStatement("update abonnementsTrack "
				+ "set base=?, baseAllDay=?, baseUnlimited=?, "
				+ "baseAllDayUnlimited=?, personalCoach=? where id=?;")){
			myStmt.setBoolean(1, track.isBase());
			myStmt.setBoolean(2, track.isBaseAllDay());
			myStmt.setBoolean(3, track.isBaseUnlimited());
			myStmt.setBoolean(4, track.isBaseAllDayUnlimited());
			myStmt.setBoolean(5, track.isPersonalCoach());
			myStmt.setInt(6, id);
			myStmt.executeUpdate();
		}catch (SQLException e){
			e.printStackTrace();
		}
	}
}
