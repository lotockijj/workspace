package newer.test;

import org.junit.Assert;
import org.junit.Test;

import newer.BubbleSort;
import newer.InsertionSort;
import newer.MergeSort;
import newer.QuickSort;
import newer.SelectionSort;

public class SortTest {
	
	@Test
	public void testBubbleSort() {
		int[] arr = {1, -2, 4, 1000, -200, 5, 3, 25};
		BubbleSort.sort(arr);
		Assert.assertEquals(-200, arr[0]);
		Assert.assertEquals(-2, arr[1]);
		Assert.assertEquals(1000, arr[arr.length - 1]);
	}
	
	@Test
	public void testSelectionSort(){
		int[] arr = {1, -2, 4, 1000, -200, 5, 5, 3, 25};
		SelectionSort.sort(arr);
		Assert.assertEquals(-200, arr[0]);
		Assert.assertEquals(-2, arr[1]);
		Assert.assertEquals(1000, arr[arr.length - 1]);
	}
	
	@Test
	public void testInsertionSort(){
		int[] arr = {1, -2, 4, 1000, -200, 5, 5, 3, 25};
		InsertionSort.sort(arr);
		Assert.assertEquals(-200, arr[0]);
		Assert.assertEquals(-2, arr[1]);
		Assert.assertEquals(1000, arr[arr.length - 1]);
	}
	
	@Test
	public void testQuickSort(){
		int[] arr = {1, -2, 4, 1000, -200, 5, 5, 3, 25};
		QuickSort.sort(arr);
		Assert.assertEquals(-200, arr[0]);
		Assert.assertEquals(-2, arr[1]);
		Assert.assertEquals(1000, arr[arr.length - 1]);
	}
	
	@Test
	public void testMergeSort(){
		int[] arr = {1, -2, 4, 1000, -200, 5, 5, 3, 25};
		MergeSort m = new MergeSort();
		m.sort(arr);
		Assert.assertEquals(-200, arr[0]);
		Assert.assertEquals(-2, arr[1]);
		Assert.assertEquals(1000, arr[arr.length - 1]);
	}

}
