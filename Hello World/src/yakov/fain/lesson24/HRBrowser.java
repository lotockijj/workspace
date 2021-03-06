package yakov.fain.lesson24;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import yakov.fain.lesson17.Employee;

public class HRBrowser {

	@MyJDBCExecutor(sqlStatement="Select *from Employee")
	public List<Employee> getEmployees(){
		// Generate the code to get the data from DBMS, place them  in ArrayList and return
		//them to the caller of my getEmployees
		return new ArrayList<Employee>();
	}

	@MyJDBCExecutor(sqlStatement="Update Employee set bonus=1000",transactionRequired=true,
			notifyOnUpdates=true)
	public void updateData(){
		//JDBC code to perform transactional updates and notifications goes here
	}

	public void getAnyClass() throws IOException{
		final File f = new File(HRBrowser.class.
				getProtectionDomain().getCodeSource().getLocation().getPath());
		System.out.println(f.getPath());
	}

	public void changeAddress(String newAddress) {
		System.out.println("The new address is " + newAddress);
	}

}
