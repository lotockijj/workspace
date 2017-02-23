package tryblobglob;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class ExampleBlob {
	
	public void insertBlobIntoTableObject(){
		Properties p = new Properties();
		p.put("user", "root");
		p.put("password", "");
		p.put("dbUrl", "jdbc:mysql://localhost:3306/my_new_data_base");
		
		FileInputStream input = null;
		String sql = "insert into object values (1, ?) ";

		try(Connection myConn = DriverManager.getConnection((String) p.get("dbUrl"), p);
			PreparedStatement stmt = myConn.prepareStatement(sql)){

			File theFile = new File("C:\\Users\\Роман Лотоцький\\"
					+ "workspace\\faberlic\\fileForTesting\\s.pdf");
			input = new FileInputStream(theFile);
			stmt.setBinaryStream(1, input);
			
			stmt.execute();
			System.out.println("Insert complete. ");
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void getObjectFromTableObject(){
		Properties p = new Properties();
		p.put("user", "root");
		p.put("password", "");
		p.put("dbUrl", "jdbc:mysql://localhost:3306/my_new_data_base");
		
		String sql = "select resume from object where id=1;";

		try(Connection myConn = DriverManager.getConnection((String) p.get("dbUrl"), p);
			PreparedStatement stmt = myConn.prepareStatement(sql)){

			File theFile = new File("C:\\Users\\Роман Лотоцький\\"
					+ "workspace\\faberlic\\fileForTesting\\fromTable.pdf");
			FileOutputStream outPut = new FileOutputStream(theFile);
			
			ResultSet myRes = stmt.executeQuery();
			
			if(myRes.next()){
				InputStream input = myRes.getBinaryStream("resume");
				byte[] buffer = new byte[1024];
				while(input.read(buffer) > 0){
					outPut.write(buffer);
				}
			}
			outPut.close();
			System.out.println("Get object from database complete. ");
		} catch(Exception e){
			e.printStackTrace();
		}
	}


}
