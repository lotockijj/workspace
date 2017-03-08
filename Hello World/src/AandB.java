import java.util.ArrayList;

/* Поміняти значення а і b без створення третьої змінної. */ 

public class AandB {

	public static void main(String[] args) {
		int a = 5;
		int b = 7; 
		a = a + b; 
		b = b + a; 
		a = b - a; 
		b = b - a - a; 
		
//		System.out.println("a = " + a + "\nb = " + b);
//		boolean c = true;
//		boolean d = false;
//		System.out.println((d || d || d || d || c));
//		
//		String s1 = "str"; 
//		String s2 = "str"; 
//		System.out.println("Result: "  + "  ______!!!! " + s1 == s2);
//		System.gc();
		
//		for(float i = 0.0f; i != 0; i += 0.1f){
//			System.out.println(i);
//		}
//		System.out.println("Done!!! :) ");
		ArrayList<Integer> test = new ArrayList<>();
		test.add(1);
		test.add(2);
		System.out.println(test.size() + " " + test.get(0) + " " + test.get(1));
	}
}
