package tutorial.oracle;

public class CharSequence{

	static String str = "Write a class that implements the"
			+ " CharSequence interface found in "
			+ "the java.lang package. Your implementation "
			+ "should return the string backwards. Select one "
			+ "of the sentences from this book to use as the data. "
			+ "Write a small main method to test your class; "
			+ "make sure to call all four methods."; 

	public  void reverse(String s){
		String st = ""; 
		for(int i = 0; i < s.length(); i++){
			st += s.charAt(s.length() - i - 1); 
		}
		System.out.println(st);
	}

	public static void main(String[] args){ //charAt(); length(); subSequence(); toString();
		CharSequence ob = new CharSequence();
		ob.reverse(str); 
	}
}
