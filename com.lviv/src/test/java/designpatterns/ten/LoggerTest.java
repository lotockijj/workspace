package designpatterns.ten;

import org.junit.Assert;
import org.junit.Test;

public class LoggerTest {

	@Test
	public void test() {
		LoggerFactory loggerFactory = new LoggerFactory();
		Logger logger = loggerFactory.getLogger();
		logger.log("Hello Roman :)");
		Assert.assertNotNull(logger);
	}

}
