package designpatterns.seventeen;

import static org.junit.Assert.*;

import org.junit.Test;

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
