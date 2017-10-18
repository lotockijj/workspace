package designpatterns.seventeen;

import org.junit.Test;

import designpatterns.flyweight.FlyweightFactory;
import designpatterns.flyweight.FlyweightIntr;

public class FlyweightFactoryTest {

	@Test
	public void test() {
		FlyweightFactory factory = FlyweightFactory.getInstance();
		FlyweightIntr vacancy = factory.getFlyweightIntr("eleks");
		vacancy.print("junior", "11");
		vacancy = factory.getFlyweightIntr("ibm");
		vacancy.print("middle", "1");
	}

}
