package designpatterns.twelve;

import org.junit.Before;
import org.junit.Test;
import org.testng.Assert;

public class AbonnementTest {
	private AbonnementFactory abonFactory;
	
	@Before
	public void setUp() throws Exception {
		abonFactory = new AdultAbonnementFactory();
	}

	@Test
	public void test() {
		Abonnement abon = abonFactory.createAbonnement("1");
		Assert.assertEquals(420, abon.getCost());
		abon = abonFactory.createAbonnement("2");
		Assert.assertEquals(490, abon.getCost());
		abon = abonFactory.createAbonnement("3");
		Assert.assertEquals(450, abon.getCost());
		abon = abonFactory.createAbonnement("4");
		Assert.assertEquals(520, abon.getCost());
		
		abonFactory = new ChildrenAbonnementFactory();
		
		abon = abonFactory.createAbonnement("1");
		Assert.assertEquals(200, abon.getCost());
		abon = abonFactory.createAbonnement("2");
		Assert.assertEquals(250, abon.getCost());
	}
	
}
