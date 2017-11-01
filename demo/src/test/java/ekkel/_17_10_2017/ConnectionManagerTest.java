package ekkel._17_10_2017;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ekkel._17_10_2017.ConnectionManager.Connection;

public class ConnectionManagerTest {
	private ConnectionManager manager;
	
	@Before
	public void setUp() throws Exception {
		manager = ConnectionManager.getInstance(3);
	}

	@Test
	public void testGetConnection() {
		Connection connection1 = manager.getConnection();
		Assert.assertNotNull(connection1);
		Connection connection2 = manager.getConnection();
		Assert.assertNotNull(connection2);
		Connection connection3 = manager.getConnection();
		Assert.assertNotNull(connection3);
		Connection connection4 = manager.getConnection();
		Assert.assertNull(connection4);
	}

}
