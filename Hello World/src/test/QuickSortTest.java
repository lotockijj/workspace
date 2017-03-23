package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import sort.QuickSort;

public class QuickSortTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		QuickSort quick = new QuickSort();
		int[] array = new int[]{1, -3, -1, -7, 8, 4, 2};
		quick.sort(array);
		for(int i = 0; i < array.length; i++){
			System.out.print(array[i] + ", ");
		}
		assertEquals(-7, array[0]);
		assertEquals(8, array[array.length - 1]);
	}

}
