package com.example;

import org.junit.Test;
import org.testng.Assert;

public class SumTest {

	@Test
	public void testSumInt() {
		Assert.assertEquals(4, Sum.sum(1111));
		Assert.assertEquals(25, Sum.sum(55555));
	}

	@Test
	public void testSumLong() {
		Assert.assertEquals(135, Sum.sum(999999999999999L));
		Assert.assertEquals(15, Sum.sum(111111111111111L));
	}

}
