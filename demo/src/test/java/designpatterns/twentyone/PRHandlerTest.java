package designpatterns.twentyone;

import org.junit.Before;
import org.junit.Test;
import org.testng.Assert;

import designpatterns.chainofresponsibility.BranchManager;
import designpatterns.chainofresponsibility.PresidentCOO;
import designpatterns.chainofresponsibility.PurchaseRequest;
import designpatterns.chainofresponsibility.RegionalDirector;
import designpatterns.chainofresponsibility.VicePresident;

public class PRHandlerTest {
	private BranchManager branchManager;
	private RegionalDirector regionalDirector;
	private VicePresident vicePresident;
	private PresidentCOO presidentCOO;
	
	@Before
	public void setUp() throws Exception {
		branchManager = new BranchManager("Branch manager Roman");
		regionalDirector = new RegionalDirector("Regional director Vasya");
		vicePresident = new VicePresident("Vice president Kolya");
		presidentCOO = new PresidentCOO("President COO Vitalic");
		
		branchManager.setNextHandler(regionalDirector);
		regionalDirector.setNextHandler(vicePresident);
		vicePresident.setNextHandler(presidentCOO);
	}

	@Test
	public void test() {
		PurchaseRequest request = new PurchaseRequest(1, "Office supplies", 20000);
		Assert.assertTrue(branchManager.authorize(request, null));
		request = new PurchaseRequest(2, "Building supplies", 50000);
		Assert.assertTrue(branchManager.authorize(request, null));
		request = new PurchaseRequest(3, "Region supplies", 150000);
		Assert.assertTrue(branchManager.authorize(request, null));
		request = new PurchaseRequest(4, "District supplies", 250000);
		Assert.assertTrue(branchManager.authorize(request, null));
		request = new PurchaseRequest(5, "Greatest supplies", 500000);
		Assert.assertFalse(branchManager.authorize(request, null));
	}

}
