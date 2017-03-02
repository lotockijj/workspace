package com.dao;

import static org.junit.Assert.*;

import org.jasypt.util.password.StrongPasswordEncryptor;
import org.junit.Before;
import org.junit.Test;

import gui.AlertGui;

public class FabDaoTest {

	@Before
	public void setUp() throws Exception {
	}

//	@Test
//	public void test() throws Exception {
//		FabDao dao = new FabDao();
//		System.out.println(dao.searchGoods("1037"));
//	}
	@Test
	public void testSetPasswordForUsers(){
		FabDao dao = null;
		try {
			dao = new FabDao();
		} catch (Exception e) {
			AlertGui.createAlertError(e);
		}
		StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
		String encryptedPassword = passwordEncryptor.encryptPassword("java");
		dao.setPasswordForUsers(encryptedPassword, 2);
		dao.setPasswordForUsers(encryptedPassword, 1);
	}

}
