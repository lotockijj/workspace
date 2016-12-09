package main.java.faberlic;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class FaberlicDAO {
	
	private Connection myConn;
	
	public FaberlicDAO() throws Exception{
	
		Properties properties = new Properties();
		properties.load(new FileInputStream("c:\\Users\\Роман Лотоцький\\workspace\\artifactId\\src\\main\\java\\faberlic\\connection.properties"));
		
		String user = properties.getProperty("user");
		String password = properties.getProperty("");
		String dburl = properties.getProperty("dburl");
		
		myConn = DriverManager.getConnection(dburl, user, password);
		
		System.out.println("DB connection successful to: " + dburl);
	}
	
	public void deleteFaberlicGoods(int faberlicId) throws SQLException{
		PreparedStatement stmt = null;
		try{
			stmt = myConn.prepareStatement("delete from faberlic_goods where id=?");
			stmt.setInt(1, faberlicId);
			stmt.executeUpdate();
		} finally {
			stmt.close();
		}
	}
	
	public void updateFaberlicGoods(Faberlic theFaberlicGoods, int userId) throws Exception{
		PreparedStatement stmt = null;
		
		try {
			stmt = myConn.prepareStatement("update faberlic_goods"
					+ " set name=?, article=?, amount=?, "
					+ "date_production=?, expiration_date=?, end_date=? "
					+ "where id=?");
			
			stmt.setString(1, theFaberlicGoods.getName());
			stmt.setInt(2, theFaberlicGoods.article);
			stmt.setInt(3, theFaberlicGoods.amount);
			stmt.setDate(4, theFaberlicGoods.getDate_production());
			stmt.setDate(5, theFaberlicGoods.getExpiration_date());
			stmt.setDate(6, theFaberlicGoods.getEnd_date());
			stmt.setInt(7, theFaberlicGoods.getId());
			
			stmt.executeUpdate();
			
			//Add audit history
			stmt = myConn.prepareStatement("insert into audit_history" 
					+ "(id, last_name, action, action_date_time) " 
					+ "values(?, ?, ?, ?)");
			stmt.setInt(1, userId);
			stmt.setString(2, theFaberlicGoods.getName());
			stmt.setString(3, "Update faberlic goods");
			stmt.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
			
			stmt.executeUpdate();
		} 
		finally{
			stmt.close();
		}
	}
	
	public void addFaberlicGoods(Faberlic theFaberlicGoods) throws Exception{
		PreparedStatement stmt = null;
		
		try{
			stmt = myConn.prepareStatement("insert into faberlic_goods"
		 + " (name, article, amount, date_production, expiration_date, end_date )"
		 + " values(?, ?, ?, ?, ?, ?)");
			stmt.setString(1, theFaberlicGoods.getName());
			stmt.setInt(2, theFaberlicGoods.getArticle());
			stmt.setInt(3, theFaberlicGoods.getAmount());
			stmt.setDate(4, (Date) theFaberlicGoods.getDate_production());
			stmt.setDate(5, (Date) theFaberlicGoods.getExpiration_date());
			stmt.setDate(6, (Date) theFaberlicGoods.getEnd_date());
			
			stmt.executeUpdate();
		}
		finally {
			stmt.close();
		}
	}
	
	
	public List<Faberlic> getAllFaberlicGoods() throws SQLException{
		List<Faberlic> list = new ArrayList<>();
		
		Statement stmt = null;
		ResultSet rs = null;
		try{
			stmt = myConn.createStatement();
			rs = stmt.executeQuery("select *from faberlic_goods");
			
			while(rs.next()){
				Faberlic tempFaberlic = convertRowToFaberlicGoods(rs);
				list.add(tempFaberlic);
			}
		} catch (SQLException e){
			System.out.println(e);
		} finally {
			//close(myConn, rs);
		}
		return list;
	}
	
	public List<Faberlic> searchFaberlicGoods(String lastName) throws Exception{
		List<Faberlic> list = new ArrayList<>();
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try{
			lastName += "%";
			stmt = myConn.prepareStatement("select *from faberlic_goods where name like ?");
			stmt.setString(1, lastName);
			rs = stmt.executeQuery();
			while(rs.next()){
				Faberlic tempFaberlic = convertRowToFaberlicGoods(rs);
				list.add(tempFaberlic);
			}
			return list;
		}
		finally {
			//close(myConn, rs);
		}
		
	}
	
	public Faberlic convertRowToFaberlicGoods(ResultSet rs) throws SQLException{
		int id = rs.getInt("id");
		String name = rs.getString("name");
		int article = rs.getInt("article");
		int amount = rs.getInt("amount");
		Date date_production = rs.getDate("date_production");
		Date expiration_date = rs.getDate("expiration_date");
		Date end_date = rs.getDate("end_date");
		
		Faberlic tempFaberlic = new Faberlic(id, name, article, amount, date_production, expiration_date, end_date);
		
		return tempFaberlic;
	}
	
	private static void close(Connection myConn, Statement stmt, ResultSet rs) throws SQLException{
		if(myConn != null){
			myConn.close();
		}
		if(stmt != null){
			stmt.close();
		}
		if(rs != null){
			rs.close();
		}
	}
	
	private static void close(Connection myConn2, ResultSet rs) throws SQLException {
		close(myConn2, null, rs);
	}
	
	public static void main(String[] args) throws Exception {
		FaberlicDAO f = new FaberlicDAO();
	}

	public List<AuditHistory> getAuditHistory(int faberlicId) {
		// TODO Auto-generated method stub
		return null;
	}

}
