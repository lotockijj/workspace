import java.util.ArrayList;

/* ������� �������� � � b ��� ��������� ������ �����. */ 

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
//		ArrayList<Integer> test = new ArrayList<>();
//		test.add(1);
//		test.add(2);
//		System.out.println(test.size() + " " + test.get(0) + " " + test.get(1));
		double a1 = 3;
		double b2 = 2.5;
		double c = -0.5;

		double x1 = (-b2 + Math.sqrt(b2*b2 - 4*a1*c))/(2*a1);
		double x2 = (-b2 - Math.sqrt(b2*b2 - 4*a1*c))/(2*a1);
		System.out.println("x1=" + x1);
		System.out.println("x2=" + x2);
		
	}
}
