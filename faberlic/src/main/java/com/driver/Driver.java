package com.driver;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Driver {

	public void connectToMySQL(){
		Properties p = new Properties();
		p.put("user", "root");
		p.put("password", "");
		p.put("dbUrl", "jdbc:mysql://localhost:3306/my_new_data_base");

		try(Connection myConn = DriverManager.getConnection((String) p.get("dbUrl"), p);
				Statement stmt = myConn.createStatement();
				ResultSet myRes = stmt.executeQuery("SELECT *FROM GOODS")){

			while(myRes.next()){
				System.out.println(myRes.getString("name") + ", " +
						myRes.getString("FABERLIC_NUMBER"));
			}
		} catch(Exception e){
			e.printStackTrace();
		}
	}

	public void insertDataInTable(){
		Properties p = new Properties();
		p.put("user", "root");
		p.put("password", "");
		p.put("dbUrl", "jdbc:mysql://localhost:3306/my_new_data_base");

		try(Connection myConn = DriverManager.getConnection((String) p.get("dbUrl"), p);
				Statement stmt = myConn.createStatement()){

			String sql = "insert into goods " +
					"(id, name, faberlic_number, price) " +
					"values(3, '10 element', 4303, 258);";
			stmt.executeUpdate(sql);
			System.out.println("Insert complete. ");
		} catch(Exception e){
			e.printStackTrace();
		}
	}

	public void updateDataInTable(){
		Properties p = new Properties();
		p.put("user", "root");
		p.put("password", "");
		p.put("dbUrl", "jdbc:mysql://localhost:3306/my_new_data_base");

		try(Connection myConn = DriverManager.getConnection((String) p.get("dbUrl"), p);
				Statement stmt = myConn.createStatement()){

			String sql = "update goods "
					+ "set faberlic_number=7 "
					+ "where id=3";
			stmt.executeUpdate(sql);
			System.out.println("Insert complete. ");
		} catch(Exception e){
			e.printStackTrace();
		}
	}

	public void deleteDataFromTable(){
		Properties p = new Properties();
		p.put("user", "root");
		p.put("password", "");
		p.put("dbUrl", "jdbc:mysql://localhost:3306/my_new_data_base");

		try(Connection myConn = DriverManager.getConnection((String) p.get("dbUrl"), p);
				Statement stmt = myConn.createStatement()){

			String sql = "delete from goods "
					+ "where id=9";
			int rowsAffected = stmt.executeUpdate(sql);
			System.out.println("Rows affected: " + rowsAffected);
			System.out.println("Deleting complete. ");
		} catch(Exception e){
			e.printStackTrace();
		}
	}

	public void createPreparedStatement(){
		Properties p = new Properties();
		p.put("user", "root");
		p.put("password", "");
		p.put("dbUrl", "jdbc:mysql://localhost:3306/my_new_data_base");

		try(Connection myConn = DriverManager.getConnection((String) p.get("dbUrl"), p);
			PreparedStatement stmt = myConn.prepareStatement("select *from goods where price > ? "
					+ "and faberlic_number=?;")){
			stmt.setInt(1, 258);
			stmt.setInt(2, 2);
			ResultSet myRes = stmt.executeQuery();
			display(myRes);
		} catch(Exception e){
			e.printStackTrace();
		}
	}

	// We haven't stored procedure in database and so this method dousn't work.
	public void createPreparedCall(){
		Properties p = new Properties();
		p.put("user", "root");
		p.put("password", "");
		p.put("dbUrl", "jdbc:mysql://localhost:3306/my_new_data_base");

		try(Connection myConn = DriverManager.getConnection((String) p.get("dbUrl"), p);
				PreparedStatement stmt = myConn.prepareCall("{call preparedStmtInDB(?,?)}")){
			String name = "name";
			int faberlicNumber = 2;
			stmt.setString(1, name);
			stmt.setInt(2, faberlicNumber);
			showData(myConn);
		} catch(Exception e){
			e.printStackTrace();
		}
	}

	public void getMetaData(){
		Properties p = new Properties();
		p.put("user", "root");
		p.put("password", "");
		p.put("dbUrl", "jdbc:mysql://localhost:3306/my_new_data_base");

		try(Connection myConn = DriverManager.getConnection((String) p.get("dbUrl"), p);
				PreparedStatement stmt = myConn.prepareCall("{call preparedStmtInDB(?,?)}")){
			DatabaseMetaData metaData = myConn.getMetaData();
			System.out.println("Product name: " + metaData.getDatabaseProductName() +"\n" +
					"Product version: " + metaData.getDatabaseMajorVersion() + "\n" +
					"JDBC Driver name: " + metaData.getDriverName() + "\n" +
					"JDBC Driver version: " + metaData.getDriverVersion());

			String catalog = null, schemaPattern = null, tableNamePattern = null, 
					columnNamePattern = null;
			String[] types = null;

			ResultSet resultSet = metaData.getTables(catalog, schemaPattern, 
					tableNamePattern, types);
			System.out.println("***********Tables from my_db******************");
			while(resultSet.next()){
				System.out.println(resultSet.getString("Table_name"));
			}

			System.out.println("******Column name from fab table are: ******************");
			resultSet = metaData.getColumns(catalog, schemaPattern, "fab", columnNamePattern);
			while(resultSet.next()){
				System.out.println(resultSet.getString("Column_name"));
			}
		} catch(Exception e){
			e.printStackTrace();
		}
	}

	public void getResultSetMetaData(){
		Properties p = new Properties();
		p.put("user", "root");
		p.put("password", "");
		p.put("dbUrl", "jdbc:mysql://localhost:3306/my_new_data_base");

		try(Connection myConn = DriverManager.getConnection((String) p.get("dbUrl"), p);
				PreparedStatement stmt = myConn.prepareCall("{call preparedStmtInDB(?,?)}")){

			ResultSet myRs = stmt.executeQuery("select discount, page, article, name, " + 
					" priceCatalog,  theSame, allowance, priceStore, ballConsultant, " +
					" priceBuyer, ballBuyer from fab;");
			ResultSetMetaData resSetMD = myRs.getMetaData();
			int columnCount = resSetMD.getColumnCount();
			System.out.println("Column count: " + columnCount + "\n");
			for(int column = 1; column <= columnCount; column++){
				System.out.println("Column name: " + resSetMD.getColumnName(column));
				System.out.println("Column type name: " + resSetMD.getColumnTypeName(column));
				System.out.println("Is Nullable: " + resSetMD.isNullable(column));
				System.out.println("Is Auto Increment: " + resSetMD.isAutoIncrement(column) + "\n");
			}
		} catch(Exception e){
			e.printStackTrace();
		}
	}

	private void showData(Connection myConn) throws SQLException {
		PreparedStatement stmt = myConn.prepareStatement("select *from goods;");
		ResultSet myRes = stmt.executeQuery();
		display(myRes);
	}

	private void display(ResultSet myRes) throws SQLException {
		while(myRes.next()){
			System.out.println(myRes.getInt(1) + ", " +
					myRes.getString(2) + ", " +
					myRes.getInt(3) + ", " +
					myRes.getInt(4));
		}
	}

}
