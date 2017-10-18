package designpatterns.fiftinth;

import java.math.BigDecimal;

import org.junit.Test;
import org.testng.Assert;

import designpatterns.composite.CompositeException;
import designpatterns.composite.Item;
import designpatterns.composite.Product;
import designpatterns.composite.ProductComponent;

public class ProductComponentTest {

	@Test
	public void test() throws CompositeException {
		ProductComponent monitor = new Item("Monitor", new BigDecimal(100));
		ProductComponent block = new Item("Block", new BigDecimal(250));
		ProductComponent dynamic = new Item("Dynamic", new BigDecimal(22));

		ProductComponent computer = new Product("Computer", new BigDecimal(0));
		computer.addComponent(monitor);
		computer.addComponent(block);
		computer.addComponent(dynamic);
		computer.addComponent(dynamic);

		Assert.assertEquals(new BigDecimal(394), computer.getPrice());
		
		ProductComponent computerClass = new Product("Class", new BigDecimal(0));
		computerClass.addComponent(computer);
		computerClass.addComponent(computer);
		computerClass.addComponent(dynamic);
		computerClass.addComponent(monitor);
		
		Assert.assertEquals(new BigDecimal(910), computerClass.getPrice());
	}

}
