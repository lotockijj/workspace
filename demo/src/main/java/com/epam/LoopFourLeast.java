package com.epam;

public class LoopFourLeast {

	public static int[] getLeastNumbers(int[] arr){
		int first = Integer.MAX_VALUE,
				second = Integer.MAX_VALUE,
				third = Integer.MAX_VALUE,
				fourth = Integer.MAX_VALUE;
		for(int i = 0; i < arr.length; i++){
			if(first > arr[i]){
				fourth = third; third = second; second = first; first = arr[i];
			} else if(second > arr[i]){
				fourth = third; third = second; second = arr[i];
			} else if(third > arr[i]){
				fourth = third; third = arr[i];
			} else if(fourth > arr[i]){
				fourth = arr[i];
			}
		}
		int[] result = {first, second, third, fourth};
		return result;
	}

}
