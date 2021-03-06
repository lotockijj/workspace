package com.epam;

import org.junit.Test;
import org.testng.Assert;

public class LoopTwoBiggestTest {

	@Test
	public void testGetTwoBiggest() {
		int[] arr = {22, -100, 77, 47, 82, 101, 10001};
		int[] result = LoopTwoBiggest.getTwoBiggest(arr);
		Assert.assertEquals(2, result.length);
		Assert.assertEquals(10001, result[0]);
		Assert.assertEquals(101, result[1]);
		int[] arr2 = {22, 21, 17, 88, 48, 1000001, 2000};
		int[] result2 = LoopTwoBiggest.getTwoBiggest(arr2);
		Assert.assertEquals(1000001, result2[0]);
		Assert.assertEquals(2000, result2[1]);
	}

}
