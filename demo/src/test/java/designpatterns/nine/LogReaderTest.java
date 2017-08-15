package designpatterns.nine;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LogReaderTest {
	private LogReader logReader;
	@Before
	public void setUp() throws Exception {
		logReader = new LogReader();
	}

	@Test
	public void testReadLog() {
		Assert.assertEquals("ACCOUNT.TXT", logReader.readLog());
	}

}
