package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import sort.SelectionSort;

public class SelectionSortTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		int[] arr = new int[]{7, 8, 2, -1, 4, -3};
		int[] sortedArr = SelectionSort.doSelectionSort(arr);
		assertEquals(-3, sortedArr[0]);
		assertEquals(8, sortedArr[sortedArr.length - 1]);
		for(int i = 0; i < sortedArr.length; i++){
			System.out.print(sortedArr[i] + ", ");
		}
	}

}
