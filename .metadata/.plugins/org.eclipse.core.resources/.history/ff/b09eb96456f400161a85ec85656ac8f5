package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.dao.FabDao;
import com.faberlic.Goods;

//faberlic...
public class QueryDB {

	public final String SQL_STATEMENT = "select * from fab";
	public final String JDBC_URL = "jdbc:derby:faberlicdb;create=true";
	ResultSet resSet = null; 
	
	public void createQuery(){
		try(Connection conn = DriverManager.getConnection(JDBC_URL)){
			Statement stmt = conn.createStatement();
			resSet = stmt.executeQuery(SQL_STATEMENT);
			ResultSetMetaData resSetMetaData = resSet.getMetaData();
			int columnCount = resSetMetaData.getColumnCount();
			for(int i = 1; i <= columnCount; i++){
				System.out.format("%20s", resSetMetaData.getColumnName(i) + " | ");
			}
			while(resSet.next()){
				System.out.println();
				for(int i = 1; i <= columnCount; i++){
					System.out.format("%20s", resSet.getString(i) + " | ");
				}
			}
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			try {
				if(resSet != null) resSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void populateDataBaseWithFaberlicGoods(){
		
		try(Connection conn = DriverManager.getConnection(JDBC_URL);
			PreparedStatement stmt = conn.prepareStatement("insert into fab ("
						+ "discount, page, article, name, priceCatalog, theSame, allowance, "
						+ "priceStore, ballConsultant, priceBuyer, ballBuyer) "
						+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")){
			
			FabDao fabDao = new FabDao();
			List<Goods>listGoods = fabDao .getAllGoods();
			
			for(int i = 0; i < listGoods.size(); i++){
				stmt.setString(1, listGoods.get(i).getDiscount());
				stmt.setString(2, listGoods.get(i).getPage());
				stmt.setString(3, listGoods.get(i).getArticle());
				stmt.setString(4, listGoods.get(i).getName());

				stmt.setBigDecimal(5, listGoods.get(i).getPriceCatalog());
				stmt.setBigDecimal(6, listGoods.get(i).getTheSame());
				stmt.setString(7, listGoods.get(i).getAllowance());
				stmt.setBigDecimal(8, listGoods.get(i).getPriceStore());
				stmt.setFloat(9, listGoods.get(i).getBallConsultant());
				stmt.setBigDecimal(10, listGoods.get(i).getPriceBuyer());
				stmt.setFloat(11, listGoods.get(i).getBallBuyer());

				stmt.executeUpdate();
			}
			System.out.println("Populating was successful");
		} catch(Exception e){
			e.printStackTrace();
		}
	}
}
