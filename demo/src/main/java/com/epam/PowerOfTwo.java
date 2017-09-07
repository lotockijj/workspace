package com.epam;

public class PowerOfTwo {
	private static String result;
	
	public static String isNumberPowerOfTwo(double n){
		if(n == 2){
			result = "Yes";
		} else if(n == 1){
			result = "No";
		} else if(n < 1){
			result = "No";
		} else {
			isNumberPowerOfTwo(n/2);
		} 
		return result;
	}
	
	public static void isNumberPowerOfTwoAttemptTwo(double n){
		if(n == 2){
			System.out.println("Yes");
		} else if(n == 1){
			System.out.println("No");
		} else if(n < 1){
			System.out.println("No");
		} else {
			isNumberPowerOfTwoAttemptTwo(n/2);
		} 
	}

}
