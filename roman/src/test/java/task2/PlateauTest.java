package task2;

import org.junit.Assert;
import org.junit.Test;

public class PlateauTest {

	@Test
	public void testSolution() {
		int[] arr = {1, 2, 2, 1, 4, 5, 5, 5, 2, 10, 2, 22, 23, 23, 23, 23};
		int[] result = Plateau.solution(arr);
		int[] expected = {4, 3, 8};
		Assert.assertArrayEquals(expected, result);
		
		int[] arr2 = {1, 2, 2, 1};
		int[] result2 = Plateau.solution(arr2);
		int[] expected2 = {0, 2, 3};
		Assert.assertArrayEquals(expected2, result2);

		//print(result);
		//print(result2);
	}
	
//	private void print(int[] arr){
//		for (int i = 0; i < arr.length; i++) {
//			System.out.print(arr[i] + " | ");
//		}
//		System.out.println();
//	}

}
