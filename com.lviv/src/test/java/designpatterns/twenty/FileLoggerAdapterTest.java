package designpatterns.twenty;

import org.junit.Test;

import designpatterns.ten.Logger;
import designpatterns.ten.LoggerFactory;
import junit.framework.Assert;

public class FileLoggerAdapterTest {

	@Test
	public void test() {
		LoggerFactory loggerFactory = new LoggerFactory();
		Logger logger = loggerFactory.getLogger();
		FileLoggerAdapter adapter = new FileLoggerAdapter(logger);
		adapter.logMessage("Hello second time Roman!!! :) :) :) ");
		Assert.assertTrue(true);
	}

}
