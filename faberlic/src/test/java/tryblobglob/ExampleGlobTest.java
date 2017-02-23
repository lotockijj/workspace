package tryblobglob;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ExampleGlobTest {

	@Before
	public void setUp() throws Exception {
	}

//	@Test
//	public void testInsertGlobIntoTableObject() {
//		ExampleGlob examleGlob = new ExampleGlob();
//		examleGlob.insertGlobIntoTableObject();
//	}
	
	@Test
	public void testGetGlobObjectFromTableObject() {
		ExampleGlob examleGlob = new ExampleGlob();
		examleGlob.getGlobObjectFromTableObject();;
	}

}
