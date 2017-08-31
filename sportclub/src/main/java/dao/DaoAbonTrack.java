package dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import tracks.AbonnementsTrack;

public class DaoAbonTrack {
	private Connection myConn;

	public DaoAbonTrack(Connection myConn) throws FileNotFoundException, IOException, SQLException{
		this.myConn = myConn;
	}

	public DaoAbonTrack() {
	}

	public List<AbonnementsTrack> getAllAbonnementsTracks(){
		List<AbonnementsTrack> list = new ArrayList<>();
		try(Statement myStmt = myConn.createStatement();
				ResultSet myRs = myStmt.executeQuery("select *from abonnementsTrack;")){
			while(myRs.next()){
				AbonnementsTrack track = convertRowToAbonnementsTrack(myRs);
				list.add(track);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public AbonnementsTrack getAbonnementsTrack(int id){
		AbonnementsTrack track = null;
		ResultSet myRs = null;
		try(PreparedStatement myStmt = myConn.prepareStatement("select *from AbonnementsTrack "
				+ "where id=?")){
			myStmt.setInt(1, id);
			myRs = myStmt.executeQuery();
			while(myRs.next()){
				track = convertRowToAbonnementsTrack(myRs);
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
		return track;
	}
	
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
	
	private AbonnementsTrack convertRowToAbonnementsTrack(ResultSet myRs) {
		AbonnementsTrack tempTrack = null;
		try{
			boolean base = myRs.getBoolean("base");
			boolean baseAllDay = myRs.getBoolean("baseAllDay");
			boolean baseUnlimited = myRs.getBoolean("baseUnlimited");
			boolean baseAllDayUnlimited = myRs.getBoolean("baseAllDayUnlimited");
			boolean personalCoach = myRs.getBoolean("personalCoach");
			tempTrack = new AbonnementsTrack(base, baseAllDay, 
					baseUnlimited, baseAllDayUnlimited, personalCoach);
		} catch (SQLException e){
			e.printStackTrace();
		}
		return tempTrack;
	}
}
