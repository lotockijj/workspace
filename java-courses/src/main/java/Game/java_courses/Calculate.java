package Game.java_courses;

public class Calculate{
	public static void main(String[] args){
		System.out.println("Calculate...");
		int first = Integer.valueOf(args[0]);
		int second = Integer.valueOf(args[1]);
		int summ = first + second;
		int remain = summ%3;
		int pow = (int)Math.pow(first, second);
		System.out.println("Sum " + summ); 
		System.out.println("Remain%= " + remain);
		System.out.println("pow(first, second) =" + pow);
 
	}
}