package tryblobglob;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import tryblobglob.ExampleBlob;

public class ExampleBlobTest {

	@Before
	public void setUp() throws Exception {
	}

//	@Test
//	public void testInsertBlobIntoTableObject() {
//		ExampleBlob exBlob = new ExampleBlob();
//		exBlob.insertBlobIntoTableObject();
//	}
	
	@Test
	public void testGetObjectFromTableObject() {
		ExampleBlob exBlob = new ExampleBlob();
		exBlob.getObjectFromTableObject();
		File theFile = new File("C:\\Users\\Роман Лотоцький\\"
				+ "workspace\\faberlic\\fileForTesting\\fromTable.pdf");
		assertTrue(theFile.exists());
	}

}
