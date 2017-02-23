package com.faberlic;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class JoinNextTest {

	JoinNext join;
	@Before
	public void setUp() throws Exception {
		join = new JoinNext();
	}

	@Test
	public void test() {
		join.createPathAndScanner();
		join.writeDataIntoDataBase(join.listGoods);
	}

}
