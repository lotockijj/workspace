package com.dao;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FabDaoTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() throws Exception {
		FabDao dao = new FabDao();
		System.out.println(dao.searchGoods("1037"));
	}

}
