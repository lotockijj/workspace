package ekkel._17_10_2017;

import java.util.Arrays;
import java.util.Random;

public class Exercise14 {
	static String str = "Static initialized string";
	static String str2;
	static String str3;
	{
		str3 = "String initialized using instance initialization.";
	}
	static{
		str2 = "Static string in block";
	}

	static {
		System.out.println(str);
		System.out.println(str2);
	}
	
	void print(){
		System.out.println("Called with object. ");
		System.out.println(str3);
	}
	
	public static void main(String[] args) {
		Exercise14 c = new Exercise14();
		c.print();
		int[] arr;
		Random r = new Random();
		arr = new int[r.nextInt(10)];
		System.out.println(Arrays.toString(arr));
	}
}
