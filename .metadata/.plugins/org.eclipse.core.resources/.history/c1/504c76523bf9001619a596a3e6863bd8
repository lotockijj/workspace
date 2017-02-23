package com.dao;

import java.io.FileInputStream;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.faberlic.Goods;

import gui.AlertGui;

public class FabDao {

	private Connection myConn;

	public FabDao() throws Exception{
		// get db properties
		Properties props = new Properties();
		props.load(new FileInputStream("demo.properties"));
		String user = props.getProperty("user");
		String password = props.getProperty("password");
		String dburl = props.getProperty("dburl");
		//connect to database
		myConn = DriverManager.getConnection(dburl, user, password);
		System.out.println("DB connection successful to: " + dburl);
	}

	public List<Goods> getAllGoods(){
		List<Goods> list = new ArrayList<>();
		try(Statement myStmt = myConn.createStatement();
				ResultSet 	myRs = myStmt.executeQuery("select *from fab;")){

			while(myRs.next()){
				Goods tempGoods = convertRowToGoods(myRs);
				list.add(tempGoods);
			}
		} catch(Exception e){
			AlertGui.createAlertError(e);
		}
		return list;
	}

	public List<Goods> searchGoods(String article){
		List<Goods> list = new ArrayList<>();

		ResultSet myRs = null;

		article += "%";
		try(PreparedStatement myStmt = myConn.prepareStatement("select *from fab "
				+ "where article like ?;")){

			myStmt.setString(1, article);

			myRs = myStmt.executeQuery();

			while(myRs.next()){
				Goods tempGoods = convertRowToGoods(myRs);
				list.add(tempGoods);
			}
		} catch (SQLException e) {
			AlertGui.createAlertError(e);
		} finally {
			try {
				myRs.close();
			} catch (SQLException e) {
				AlertGui.createAlertError(e);
			}
		}
		return list;
	}

	public void addGoods(Goods theGoods){
		try(PreparedStatement myStmt = myConn.prepareStatement("insert into fab ("
				+ "discount, page, article, name, priceCatalog, theSame, allowance, "
				+ "priceStore, ballConsultant, priceBuyer, ballBuyer) "
				+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);")){

			myStmt.setString(1, theGoods.getDiscount());
			myStmt.setString(2, theGoods.getPage());
			myStmt.setString(3, theGoods.getArticle());
			myStmt.setString(4, theGoods.getName());

			myStmt.setBigDecimal(5, theGoods.getPriceCatalog());
			myStmt.setBigDecimal(6, theGoods.getTheSame());
			myStmt.setString(7, theGoods.getAllowance());
			myStmt.setBigDecimal(8, theGoods.getPriceStore());
			myStmt.setFloat(9, theGoods.getBallConsultant());
			myStmt.setBigDecimal(10, theGoods.getPriceBuyer());
			myStmt.setFloat(11, theGoods.getBallBuyer());

			myStmt.executeUpdate();
			alignDataBase();
		} catch (SQLException e){
			AlertGui.createAlertError(e);
		}
	}

	public void updateGoods(Goods newGoods, int id){
		try(PreparedStatement myStmt = myConn.prepareStatement("update fab set discount=?, "
				+ "page=?, article=?, name=?, priceCatalog=?, theSame=?, allowance=?, "
				+ "priceStore=?, ballconsultant=?, priceBuyer=?, ballBuyer=? where id=?;")){

			myStmt.setString(1, newGoods.getDiscount());
			myStmt.setString(2, newGoods.getPage());
			myStmt.setString(3, newGoods.getArticle());
			myStmt.setString(4, newGoods.getName());

			myStmt.setBigDecimal(5, newGoods.getPriceCatalog());
			myStmt.setBigDecimal(6, newGoods.getTheSame());
			myStmt.setString(7, newGoods.getAllowance());
			myStmt.setBigDecimal(8, newGoods.getPriceStore());
			myStmt.setFloat(9, newGoods.getBallConsultant());
			myStmt.setBigDecimal(10, newGoods.getPriceBuyer());
			myStmt.setFloat(11, newGoods.getBallBuyer());

			myStmt.setInt(12, id);

			myStmt.executeUpdate();
			alignDataBase();
		} catch (SQLException e){
			AlertGui.createAlertError(e);
		}
	}

	public void deleteGoods(int id){
		try(PreparedStatement myStmt = myConn.prepareStatement(""
				+ "delete from fab where id=?;")){
			myStmt.setInt(1, id);
			myStmt.executeUpdate();
			alignDataBase();
		} catch (SQLException e){
			AlertGui.createAlertError(e);
		}
	}

	// delete gaps after deleting row from database; 
	private void alignDataBase() {
		try(PreparedStatement myStmt = myConn.prepareStatement(
				" set @count = 0;"); 
				PreparedStatement myStmt2 = myConn.prepareStatement(
						"update fab set fab.id = @count:= @count + 1;")){
			myStmt.executeUpdate();
			myStmt2.executeUpdate();
		} catch (SQLException e){
			AlertGui.createAlertError(e);
		}
	}

	private Goods convertRowToGoods(ResultSet myRs){
		Goods tempGoods = new Goods();
		try{
			String discount = myRs.getString("discount");
			String page = myRs.getString("page");
			String article = myRs.getString("article");
			String name = myRs.getString("name");

			BigDecimal priceCatalog = myRs.getBigDecimal("priceCatalog");
			BigDecimal theSame = myRs.getBigDecimal("theSame");
			String allowance = myRs.getString("allowance");
			BigDecimal priceStore = myRs.getBigDecimal("priceStore");
			float ballConsultant = myRs.getFloat("ballConsultant");
			BigDecimal priceBuyer = myRs.getBigDecimal("priceBuyer");
			float ballBuyer = myRs.getFloat("ballBuyer");

			tempGoods = new Goods(discount, page, article, name, priceCatalog, 
					theSame, allowance, priceStore, ballConsultant, priceBuyer, ballBuyer);
		} catch (SQLException e){
			AlertGui.createAlertError(e);
		}
		return tempGoods;
	}

}
