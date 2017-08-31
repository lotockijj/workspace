package dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DaoBalance {
	private Connection myConn;
	
	public DaoBalance(Connection myConn) throws SQLException, FileNotFoundException, IOException{
		this.myConn = myConn;
	}

	public List<BigDecimal> getListBalances(){
		List<BigDecimal> list = new ArrayList<>();
		try(Statement myStmt = myConn.createStatement();
				ResultSet myRs = myStmt.executeQuery("select *from balance;")){
			while(myRs.next()){
				BigDecimal tempBalance = myRs.getBigDecimal("money");
				list.add(tempBalance);
			}
		} catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	
	public BigDecimal getBalance(int id){
		BigDecimal balance = null;
		ResultSet myRs = null;
		try(PreparedStatement myStmt = myConn.prepareStatement("select * from balance "
				+ "where id=?;")){
			myStmt.setInt(1, id);
			myRs = myStmt.executeQuery();
			myRs.next();
			balance = myRs.getBigDecimal("money");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				myRs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return balance;
	}
	
	public void updateBalance(BigDecimal balance, int id){
		try(PreparedStatement myStmt = myConn.prepareStatement("update balance "
				+ "set monet=? where id=?;")){
			myStmt.setBigDecimal(1, balance);
			myStmt.setInt(2, id);
			myStmt.executeUpdate();
		}catch (SQLException e){
			e.printStackTrace();
		}
	}
	
}
