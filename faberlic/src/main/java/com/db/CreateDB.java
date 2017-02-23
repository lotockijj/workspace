package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CreateDB {

	public final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
	public final String JDBC_URL = "jdbc:derby:faberlicdb;create=true";

	public void createDerbyDataBase() throws ClassNotFoundException{
		Class.forName(DRIVER);
		try(Connection connection = DriverManager.getConnection(JDBC_URL)){
			connection.createStatement().execute("create table fab(discount varchar(255), "
					+ "page varchar(20), article varchar(255), name varchar(255), "
					+ "priceCatalog decimal(5, 2), theSame decimal(5, 2), allowance varchar(255),"
					+ "priceStore decimal(10,2), ballConsultant float, priceBuyer decimal(10,2),"
					+ "ballBuyer float)");
			
			connection.createStatement().execute("insert into fab values "
					+ "('test discount', 'page test', 'article Test' , 'test name', "
					+ " 10.22, 11.33, 'allowance test', 12.44, 3.01, 13.55, 3.02)");
			System.out.println("Channels table created and records successfully inserted ...");
		}catch (SQLException e2){
			e2.printStackTrace();
		}
	}

}
