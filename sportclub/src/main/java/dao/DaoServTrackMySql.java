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

import tracks.ServicesTrack;

public class DaoServTrackMySql {
	private Connection myConn;

	public DaoServTrackMySql(Connection myConn) throws FileNotFoundException, IOException, SQLException{
		this.myConn = myConn;
	}

	public List<ServicesTrack> getAllServicesTracks(){
		List<ServicesTrack> list = new ArrayList<>();
		try(Statement myStmt = myConn.createStatement();
				ResultSet myRs = myStmt.executeQuery("select *from servicesTrack;")){
			while(myRs.next()){
				ServicesTrack track = convertRowToServicesTrack(myRs);
				list.add(track);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public ServicesTrack getServicesTrack(int id){
		ServicesTrack track = null;
		ResultSet myRs = null;
		try(PreparedStatement myStmt = myConn.prepareStatement("select *from servicesTrack "
				+ "where id=?")){
			myStmt.setInt(1, id);
			myRs = myStmt.executeQuery();
			track = convertRowToServicesTrack(myRs);
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

	private ServicesTrack convertRowToServicesTrack(ResultSet myRs) {
		ServicesTrack tempTrack = null;
		try{
			boolean takeGeneralMassage = myRs.getBoolean("takeGeneralMassage");
			boolean takeSolyariy = myRs.getBoolean("takeSolyariy");
			boolean takeKrosfit = myRs.getBoolean("takeKrosfit");
			boolean takeYoga = myRs.getBoolean("takeYoga");
			int numberVisitsMonthly = myRs.getInt("numberVisitsMonthly");
			tempTrack = new ServicesTrack(takeGeneralMassage, takeSolyariy, 
					takeKrosfit, takeYoga, numberVisitsMonthly);
		} catch (SQLException e){
			e.printStackTrace();
		}
		return tempTrack;
	}
}
