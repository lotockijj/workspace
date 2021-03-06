package designpatterns.seven;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ConstantDataManager2Test {
	ConstantDataManager2 manager;
	
	@Before
	public void setUp() throws Exception {
		manager = new ConstantDataManager2();
	}

	@Test
	public void test() {
		manager.readDataFromFile();
		Assert.assertEquals("ACCOUNT.TXT", manager.ACCOUNT_DATA_FILE);
		Assert.assertEquals(2, manager.VALID_MIN_LNAME_LEN);
		Assert.assertEquals("ADDRESS.TXT", manager.ADDRESS_DATA_FILE);
		Assert.assertEquals(2, manager.VALID_ST_LEN);
		Assert.assertEquals("0123456789", manager.VALID_ZIP_CHARS); 
		Assert.assertEquals("USA", manager.DEFAULT_COUNTRY); 
		Assert.assertEquals("CC.TXT", manager.CC_DATA_FILE); 
		Assert.assertEquals("0123456789", manager.VALID_CC_CHARS); 
		Assert.assertEquals("MASTER", manager.MASTER); 
		Assert.assertEquals("VISA", manager.VISA); 
		Assert.assertEquals("DISCOVER", manager.DISCOVER); 
	}

}
