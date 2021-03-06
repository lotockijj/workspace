package com.epam;

import org.junit.Assert;
import org.junit.Test;

public class PowerOfTwoTest {

	@Test
	public void testIsNumberPowerOfTwo() {
		Assert.assertEquals("No",  PowerOfTwo.isNumberPowerOfTwo(200));
		Assert.assertEquals("Yes", PowerOfTwo.isNumberPowerOfTwo(16));
		Assert.assertEquals("Yes", PowerOfTwo.isNumberPowerOfTwo(32));
		Assert.assertEquals("Yes", PowerOfTwo.isNumberPowerOfTwo(512));
		Assert.assertEquals("No",  PowerOfTwo.isNumberPowerOfTwo(21));
	}
	
	@Test
	public void testIsNumberPowerOfTwoAttemptTwo() {
		PowerOfTwo.isNumberPowerOfTwoAttemptTwo(200);
		PowerOfTwo.isNumberPowerOfTwoAttemptTwo(16);
		PowerOfTwo.isNumberPowerOfTwoAttemptTwo(32);
		PowerOfTwo.isNumberPowerOfTwoAttemptTwo(512);
		PowerOfTwo.isNumberPowerOfTwoAttemptTwo(21);
	}

}
