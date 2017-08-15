package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CreateDB {

	public final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
	public final String JDBC_URL = "jdbc:derby:client;create=true";
	
	public void createDerbyDataBase() throws ClassNotFoundException{
		Class.forName(DRIVER);
		try(Connection connection = DriverManager.getConnection(JDBC_URL)){
			
			connection.createStatement().execute("create table client("
					+ "id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), "
					+ "lastName varchar(255) not null, "
					+ "firstName varchar(255) not null, "
					+ "age int not null, "
					+ "birthDate date, "
					+ "cityName varchar(255), "
					+ "gender varchar(5), "
					+ "bodyBuildingWinner boolean, "
					+ "startDate date, "
					+ "PRIMARY KEY (id))");
			
			connection.createStatement().execute("insert into client(lastName, firstName, age, "
					+ "birthDate, cityName, gender, bodyBuildingWinner, startDate) values("
					+ "'Lotockiy', 'Roman', 35, "
					+ "'1981-10-11', 'Lviv', 'MAN', false, '2017-08-04')");
				
					
			connection.createStatement().executeUpdate("drop table client");
			
			connection.createStatement().execute("create table servicesTrack("
					+ "id integer references client(id),"
					+ "takeGeneralMassage boolean, "
					+ "takeSolyariy boolean, "
					+ "takeKrosfit boolean, "
					+ "takeYoga boolean, "
					+ "numberVisitsMonthly integer)");
				
			connection.createStatement().executeUpdate("drop table servicesTrack");
			System.out.println("Records successfully inserted ...");
		}catch (SQLException e){
			e.printStackTrace();
		}
	}

}
