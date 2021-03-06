package spartez.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import spartez.MyFindArray;
/*[4,9,3,7,8] and [3,7] should return 2.
[1,3,5] and [1] should return 0.
[7,8,9] and [8,9,10] should return -1.
[4,9,3,7,8,3,7,1] and [3,7] should return 5.
*/
public class MyFindArrayTest {
	private MyFindArray myFind;
	
	@Before
	public void setUp() throws Exception {
		myFind = new MyFindArray();
	}

	@Test
	public void test() {
		int[] arr1 = {4, 9, 3, 7, 8};
		int[] subArr1 = {3, 7};
		Assert.assertEquals(2, myFind.findArray(arr1, subArr1));
		int[] arr2 = {1, 3, 5};
		int[] subArr2 = {1};
		Assert.assertEquals(0, myFind.findArray(arr2, subArr2));
		int[] arr3 = {7, 8, 9};
		int[] subArr3 = {8, 9, 10};
		Assert.assertEquals(-1, myFind.findArray(arr3, subArr3));
		//[4,9,3,7,8,3,7,1] and [3,7] should return 5.
		int[] arr4 = {4, 9, 3, 7, 8, 3, 7, 1};
		int[] subArr4 = {3, 7};
		Assert.assertEquals(5, myFind.findArray(arr4, subArr4));
		
		
	}

}
