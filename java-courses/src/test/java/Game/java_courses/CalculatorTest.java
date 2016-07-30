package Game.java_courses;

import org.junit.Assert;
import org.junit.Test;

import junit.framework.TestCase; 

public class CalculatorTest extends TestCase {
	
	@Test
	public void testAdd()throws Exception{
		Calculator calculator = new Calculator();
		calculator.add(1, 1);
		Assert.assertEquals(2, calculator.getResult());
	}
	
	@Test(expected = UserException.class)
	public void testDiv()throws Exception{
		Calculator calculator = new Calculator();
		calculator.div(1, 1);
		Assert.assertEquals(2, calculator.getResult());
	}

}
