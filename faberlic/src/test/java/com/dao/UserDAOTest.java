package com.dao;

import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import gui.User;

public class UserDAOTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		try{
			UserDAO userDao = new UserDAO();
			List<User> listUsers = userDao.getAllUsers();
			assertTrue(listUsers.size() == 2);
		} catch (FileNotFoundException e){
			e.printStackTrace();
		} catch (SQLException e2){
			e2.printStackTrace();
		} catch (IOException e3){
			e3.printStackTrace();
		}
	}

}
