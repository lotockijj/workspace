package leobit;

public class Test {

	public static void main(String[] args) {
		String s = "Hello";
		appendWord(s);
		System.out.println(s);
		StringBuffer sb = new StringBuffer("Hello");
		appendWord(sb);
		
		System.out.println(sb);
	}
		public static void appendWord(String s){
			s += "World";
			System.out.println(s);
		}
		
		public static void appendWord(StringBuffer s){
			s.append("World");
			System.out.println(s);
		}

}
