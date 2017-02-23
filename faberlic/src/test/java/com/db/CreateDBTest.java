package com.db;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CreateDBTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		CreateDB createDB = new CreateDB();
		try {
			createDB.createDerbyDataBase();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
