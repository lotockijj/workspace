package com.driver;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DriverTest {

	@Before
	public void setUp() throws Exception {
	}

//	@Test
//	public void testConectToMySql() {
//		Driver driver = new Driver();
//		driver.connectToMySQL();
//	}
	
//	@Test
//	public void testInsertData(){
//		Driver driver = new Driver();
//		driver.insertDataInTable();
//	}
	
//	@Test
//	public void testUpdateData(){
//		Driver driver = new Driver();
//		driver.updateDataInTable();
//	}

//	@Test 
//	public void testDeletingData(){
//		Driver driver = new Driver();
//		driver.deleteDataFromTable();
//	}
	
//	@Test 
//	public void testPreparedStatement(){
//		Driver driver = new Driver();
//		driver.createPreparedStatement();
//	}
	
//	@Test
//	public void testGetMetaData(){
//		Driver driver = new Driver();
//		driver.getMetaData();
//	}
	
	@Test
	public void testGetMetaData(){
		Driver driver = new Driver();
		driver.getResultSetMetaData();
	}
}
