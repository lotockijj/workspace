package designpatterns.twentytwo;

import java.text.ParseException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PurchaseFacadeTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() throws ParseException {
		PurchaseFacade facade = new PurchaseFacade();
		System.out.println("Hash code: " + facade.hashCode() + "\n" +
				"Get class: " + facade.getClass() + "\n" + facade.toString());
		Assert.assertTrue(facade.getDataFromPropertiesFile());
		PurchaseFacade newFacade = facade;
		newFacade.setName("Third name");
		newFacade.writeDataIntoPropertiesFile();
		Assert.assertTrue(newFacade.getDataFromPropertiesFile());
	}

}
