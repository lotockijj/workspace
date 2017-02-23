package tryblobglob;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class ExampleGlob {

	public void insertGlobIntoTableObject(){
		Properties p = new Properties();
		p.put("user", "root");
		p.put("password", "");
		p.put("dbUrl", "jdbc:mysql://localhost:3306/my_new_data_base");

		String sql = "insert into largetext values (1, ?) ";

		try(Connection myConn = DriverManager.getConnection((String) p.get("dbUrl"), p);
				PreparedStatement stmt = myConn.prepareStatement(sql)){

			File theFile = new File("C:\\Users\\Роман Лотоцький\\"
					+ "workspace\\faberlic\\fileForTesting\\test.txt");

			FileReader input = new FileReader(theFile);
			stmt.setCharacterStream(1, input);

			stmt.executeUpdate();
			System.out.println("Insert complete. ");
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void getGlobObjectFromTableObject(){
		Properties p = new Properties();
		p.put("user", "root");
		p.put("password", "");
		p.put("dbUrl", "jdbc:mysql://localhost:3306/my_new_data_base");
		
		String sql = "select resume from largetext where id=1;";

		try(Connection myConn = DriverManager.getConnection((String) p.get("dbUrl"), p);
			PreparedStatement stmt = myConn.prepareStatement(sql)){

			ResultSet myRes = stmt.executeQuery();
			
			File theFile = new File("C:\\Users\\Роман Лотоцький\\"
					+ "workspace\\faberlic\\fileForTesting\\ResumeFromDB.txt");
			FileOutputStream output = new FileOutputStream(theFile);
			
			
			if(myRes.next()){
				Reader input = myRes.getCharacterStream("resume");
				int theChar;
				while((theChar = input.read()) > 0){
					output.write(theChar);
				}
			}
			output.close();
			System.out.println("Get GLOB object from database complete. ");
		} catch(Exception e){
			e.printStackTrace();
		}
	}



}
