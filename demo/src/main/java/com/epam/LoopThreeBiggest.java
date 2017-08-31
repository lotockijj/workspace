package com.epam;

// Get three biggest numbers from loop only with one iteration.

public class LoopThreeBiggest {
	
	public static int[] getTreeBiggest(int[] arr){
		int first = arr[0];
		int second = arr[1];
		int third = arr[2];
		for(int i = 3; i < arr.length; i++){
			int temp = i;
			if(first < arr[i]){
				first = arr[i];
				i++;
				if(i >= arr.length) break;
			} else i--;
			if(second < arr[i]){
				second = arr[i];
				i++;
				if(i >= arr.length) break;
			} else i--;
			if(third < arr[i]){
				i++;
				if(i >= arr.length) break;
			} else i--;
			if(i < temp){
				i = temp;
			}
		}
		int[] resultArray = {first, second, third};
		return resultArray;
	}

	public static int[] getThreeBiggestSecondAttempt(int[] arr){
		int first = Integer.MIN_VALUE;
		int second = Integer.MIN_VALUE;
		int third = Integer.MIN_VALUE;
		for(int i = 0; i < arr.length; i++){
			if(first < arr[i]){
				third = second; second = first; first = arr[i];
			} else
			if(second < arr[i]){
				third = second; second = arr[i];
			} else
			if(third < arr[i]){
				third = arr[i];
			}
		}
		int[] result = {first, second, third};
		return result;
	}
}
