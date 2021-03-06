package com.epam;

import org.junit.Test;

public class LoopThreeBiggestTest {

	@Test
	public void testGetTreeBiggest() {
		int[] arr = {1, 7, 100, 27, 28, 99, 101};
		printArrayValues(arr);
		int[] arr2 = {100, 100, 100, 1, 1, 1};
		printArrayValues(arr2);
		int[] arr3 = {1, 2, -5, -22, 1000, 200, 55};
		printArrayValues(arr3);
		
		System.out.println("\nSecond attempt:");
		printArrayValues2(arr);
		printArrayValues2(arr2);
		printArrayValues2(arr3);
	}
	
	private void printArrayValues(int[] arr){
		int[] resultArray = LoopThreeBiggest.getTreeBiggest(arr);
		System.out.println(resultArray[0] + " | " + resultArray[1] + " | " + resultArray[2]);
	}
	
	private void printArrayValues2(int[] arr){
		int[] resultArray = LoopThreeBiggest.getThreeBiggestSecondAttempt(arr);
		System.out.println(resultArray[0] + " | " + resultArray[1] + " | " + resultArray[2]);
	}
}
