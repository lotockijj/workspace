package ekkel;

import org.junit.Before;
import org.junit.Test;
import org.testng.Assert;

public class ShapeTest {
	private Circle circle;
	private Square square;

	@Before
	public void setUp() throws Exception {
		circle = new Circle();
		square = new Square();
	}

	@Test
	public void testDraw() {
		Assert.assertTrue("Draw circle...".equals(Shape.doDraw(circle)));
		Assert.assertTrue("Draw square...".equals(Shape.doDraw(square)));
	}

	@Test
	public void testErase() {
		Assert.assertTrue("Erase circle".equals(Shape.doErase(circle)));
		Assert.assertTrue("Erase square...".equals(Shape.doErase(square)));
	}

}
