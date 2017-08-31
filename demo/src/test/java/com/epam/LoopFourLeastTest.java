package com.epam;

import org.junit.Test;
import org.testng.Assert;

public class LoopFourLeastTest {

	@Test
	public void test() {
		int[] arr = {1, -1000, 2, 3, 4, 1000, 2000, - 100, - 10};
		int[] result = LoopFourLeast.getLeastNumbers(arr);
		Assert.assertEquals(-1000, result[0]);
		Assert.assertEquals(-100, result[1]);
		Assert.assertEquals(-10, result[2]);
		Assert.assertEquals(1, result[3]);
	}

}
