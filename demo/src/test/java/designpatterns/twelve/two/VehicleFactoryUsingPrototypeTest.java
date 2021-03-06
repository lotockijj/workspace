package designpatterns.twelve.two;

import org.junit.Test;
import org.testng.Assert;

public class VehicleFactoryUsingPrototypeTest {

	@Test
	public void test() {
		Car car = new LuxuryCar("toyota");
		SUV suv = new NonLuxurySUV("super lift");
		
		VehicleFactory factory = new VehicleFactoryUsingPrototype(car, suv);
		Car myCar = factory.getCar();
		Assert.assertEquals("toyota", myCar.getCarName());
		Assert.assertEquals("Conditioning, computer, TV, JPS.", myCar.getCarFeatures());
		SUV mySUV = factory.getSUV();
		Assert.assertEquals("Empty SUV", mySUV.getSUVFeatures());
	}

}
