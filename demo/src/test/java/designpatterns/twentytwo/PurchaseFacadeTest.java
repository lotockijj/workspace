package designpatterns.twentytwo;

import java.text.ParseException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import designpatterns.facade.PurchaseFacade;

public class PurchaseFacadeTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() throws ParseException {
		PurchaseFacade facade = new PurchaseFacade();
		Assert.assertTrue(facade.getDataFromPropertiesFile());
		PurchaseFacade newFacade = facade;
		newFacade.setName("Third name");
		newFacade.writeDataIntoPropertiesFile();
		Assert.assertTrue(newFacade.getDataFromPropertiesFile());
		System.out.println(newFacade);
	}

}
