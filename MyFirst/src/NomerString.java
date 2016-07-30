
public class NomerString {
	public static void main(String[] args){
		String t = "I like leArn English very much";
		char Achar = t.charAt(9);
		System.out.println("Ninth letter is " + Achar);
		String tt = t.substring(5,15);
		System.out.println("The letters between 3 and 10 are" +" "+ tt);
		String i = t.trim();
		System.out.println(i);
		String a =  (String) t.subSequence( 9, 11);
		System.out.println(a);
		String x = t.toLowerCase();
		System.out.println("Lowercase" + " " + x);
		String y = t.toUpperCase();
		System.out.println("Uppercase" + " " + y);
		int z = t.indexOf(9);
		System.out.println(z);
		int b = t.lastIndexOf(9);
		System.out.println(b);
		boolean y1 = t.contains(t);
		System.out.println(y1);
		
	}
}
