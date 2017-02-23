package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CreateDB {

	public final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
	public final String JDBC_URL = "jdbc:derby:zadb;create=true";

	public void createDerbyDataBase() throws ClassNotFoundException{
		Class.forName(DRIVER);
		try(Connection connection = DriverManager.getConnection(JDBC_URL)){
			connection.createStatement().execute("create table channels(channel varchar(20), "
					+ "topic varchar(20), videoclip varchar(20))");
			connection.createStatement().execute("insert into channels values "
					+ "('oodp', 'creational', 'singleton'), "
					+ "('oodp', 'creational', 'factory method'), "
					+ "('oodp', 'creational', 'abstract factory')");
			System.out.println("Channels table created and records successfully inserted ...");
		}catch (SQLException e2){
			e2.printStackTrace();
		}
	}

}
