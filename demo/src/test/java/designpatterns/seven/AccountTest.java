package designpatterns.seven;

import org.junit.Before;
import org.junit.Test;

import org.junit.Assert;

public class AccountTest {
	private Account account;
	
	@Before
	public void setUp() throws Exception {
		account = new Account();
	}

	@Test
	public void testGetData() {
		Assert.assertEquals("ACCOUNT.TXT", account.getAccountDataFile());
	}

}
