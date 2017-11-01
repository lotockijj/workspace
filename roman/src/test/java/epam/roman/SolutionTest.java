package epam.roman;

//import static org.junit.Assert.assertEquals;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

import org.junit.Before;
import org.junit.Rule;
//import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

public class SolutionTest {
	//private App app; 
	@Rule
	public final TextFromStandardInputStream systemInMock
	= emptyStandardInputStream();
	
	@Before
	public void setUp() throws Exception {
		//app = new App();
	}

	/*
	@Test
	public void testGetUserInputFirstNumber() {
		systemInMock.provideText("1");
		app.getUserInputFirstNumber();
		assertEquals(1, app.getFirstNumber());
	}
	
	@Test
	public void testGetUserInputSecondNumber() {
		systemInMock.provideText("2");
		app.getUserInputSecondNumber();
		assertEquals(2, app.getSecondNumber());
	}
*/
}
