/* Поміняти значення а і b без створення третьої змінної. */ 

public class AandB {

	public static void main(String[] args) {
		int a = 5;
		int b = 7; 
		a = a + b; 
		b = b + a; 
		a = b - a; 
		b = b - a - a; 
		
		System.out.println("a = " + a + "\nb = " + b);
		boolean c = true;
		boolean d = false;
		System.out.println((d || d || d || d || c));
		
		String s1 = "str"; 
		String s2 = "str"; 
		System.out.println("Result: "  + "  ______!!!! " + s1 == s2);
	}
}
