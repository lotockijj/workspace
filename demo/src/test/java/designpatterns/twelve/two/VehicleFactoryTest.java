package designpatterns.twelve.two;

import org.junit.Test;
import org.testng.Assert;

public class VehicleFactoryTest {

	@Test
	public void test() {
		VehicleFactory factory = VehicleFactory.getVehicleFactory("Luxury");
		
		Car car = factory.getCar();
		Assert.assertEquals("Conditioning, computer, TV, JPS.", car.getCarFeatures());
		
		SUV suv = factory.getSUV();
		Assert.assertEquals("Caterpillar", suv.getSUVName("Caterpillar"));
		Assert.assertEquals("Conditioning, JPS, bed.", suv.getSUVFeatures());
		
		factory = VehicleFactory.getVehicleFactory("Non-Luxury");
		
		car = factory.getCar();
		Assert.assertEquals("Empty set", car.getCarFeatures());
		
		suv = factory.getSUV();
		Assert.assertEquals("Empty SUV", suv.getSUVFeatures());
	}

}
