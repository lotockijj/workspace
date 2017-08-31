package com.epam;

public class LoopTwoBiggest {
	
	public static int[] getTwoBiggest(int[] arr){
		int first = Integer.MIN_VALUE;
		int second = Integer.MIN_VALUE;
		for(int i = 0; i < arr.length; i++){
			if(arr[i] > first){
				second = first; first = arr[i];
			} else if(arr[i] > second){
				second = arr[i];
			}
		} 
		int[] result = {first, second};
		return result;
	}

}
