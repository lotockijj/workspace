package junit;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ToStringHelper {

	StringHelper helper; 
	@Before
	public void before() {
		helper = new StringHelper();
		//System.out.println("Before");
	}
	@After
	public void after() {
		//System.out.println("After");
	}

	@Test
	public void testTruncateAInFirst2Positions() {
		System.out.println("testTruncateAInFirst2Positions");
		//StringHelper helper = new StringHelper();
		assertEquals("RTAA", helper.truncateAInFirst2Positions("RTAA"));
		assertEquals("BB", helper.truncateAInFirst2Positions("AABB"));
		assertEquals("BBB", helper.truncateAInFirst2Positions("BABB"));
	}
	@Test
	public void testAreFirstAndLastTwoCharactersTheSame(){
		System.out.println("testAreFirstAndLastTwoCharactersTheSame");
		//StringHelper helper = new StringHelper();
		assertFalse(helper.areFirstAndLastTwoCharactersTheSame(""));
		assertFalse(helper.areFirstAndLastTwoCharactersTheSame("A"));
		assertTrue(helper.areFirstAndLastTwoCharactersTheSame("AB"));
		assertTrue(helper.areFirstAndLastTwoCharactersTheSame("AAA"));
		assertFalse(helper.areFirstAndLastTwoCharactersTheSame("AAB"));
	}
	@Test
	public void testArraysSort(){
		int[] numbers = {5, 6, 4, 2, 3, 1};
		Arrays.sort(numbers);
		int[] expectedOutPut = {1, 2, 3, 4, 5, 6};
		assertArrayEquals(expectedOutPut, numbers);
	}
	@Test(expected = NullPointerException.class)
	public void testArraysSortWithNullCondition(){
		int[] numbers = null;
		Arrays.sort(numbers); // int[] numbers = {};
	}
	@Test(timeout = 100)  //Test(timeout = 2)  - > fails
	public void testArraysSort2(){
		for(int i = 0; i < 1000000; i++){
			int[] numbers = {i, i-1, i+1};
			Arrays.sort(numbers);// How much time test require? 
		}
	}

}
