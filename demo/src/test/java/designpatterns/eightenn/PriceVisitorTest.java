package designpatterns.eightenn;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.testng.Assert;

import designpatterns.fiftinth.CompositeException;
import designpatterns.fiftinth.Item;
import designpatterns.fiftinth.Product;
import designpatterns.fiftinth.ProductComponent;

public class PriceVisitorTest {

	@Test
	public void test() throws CompositeException {
		Item monitor = new Item("Monitor", new BigDecimal(100));
		Item block = new Item("Block", new BigDecimal(250));
		Item dynamic = new Item("Dynamic", new BigDecimal(50));
		
		Product computer = new Product("Computer", new BigDecimal(0));
		computer.addComponent(monitor);
		computer.addComponent(block);
		computer.addComponent(dynamic);
		computer.addComponent(dynamic);
		
		List<ProductComponent> prComp = new ArrayList<>();
		prComp.add(computer);
		prComp.add(monitor);
		prComp.add(dynamic);
		prComp.add(dynamic);
		VisitorIntr visitor = new PriceVisitor();
		//NameVisitor nameVisitor = new NameVisitor();
		for(ProductComponent pr : prComp){
			//pr.accept(nameVisitor);
			pr.accept(visitor);
		}
		Assert.assertEquals(4, prComp.size());
	}

}