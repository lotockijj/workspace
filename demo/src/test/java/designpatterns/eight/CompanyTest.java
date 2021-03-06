package designpatterns.eight;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class CompanyTest {
	private Company company;
	private Address address;
	
	@Before
	public void setUp() throws Exception {
		address = new Address("UA", "Lviv", "S.Bandera 43/5a");
		company = new Company("SoftServe", address, 55555555, 77777777);
		
	}

	@Test
	public void test() throws CloneNotSupportedException {
		Assert.assertEquals("SoftServe", company.getName());
		Assert.assertEquals("Kiev", address.getCity());
	}

}
