package test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import yakov.fain.lesson24.HRBrowser;

public class HRBrowserTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() throws IOException {
		HRBrowser hRBrowser = new HRBrowser();
		hRBrowser.getAnyClass();
		
	}

}
