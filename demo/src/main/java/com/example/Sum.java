package com.example;

public class Sum {
	
	public static int sum(int number){
		String str = Integer.toString(number);
		int sum = 0;
		for (int i = 0; i < str.length(); i++) {
			sum += Character.getNumericValue(str.charAt(i));
		}
		return sum;
	}
	
	public static int sum(long number){
		String str = Long.toString(number);
		int sum = 0;
		for (int i = 0; i < str.length(); i++) {
			sum += Character.getNumericValue(str.charAt(i));
		}
		return sum;
	}
	
}