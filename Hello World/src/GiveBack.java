public class GiveBack {
	static char f = '\u004d' ; 
	public static void main(String[] args) {
		int [] x = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}; 
		int [] y = new int[x.length]; 
		for(int i = 0; i < x.length; i++){
			y[i] = x[x.length - i - 1]; 
			System.out.println(y[i]);
		}
		
		GiveBack a = new GiveBack();
		@SuppressWarnings("unchecked")
		Class<GiveBack> aclass = (Class<GiveBack>) a.getClass(); 
		System.out.println(aclass);
		try {
			Class<?> c = Class.forName("java.lang.Byte");
			System.out.println(c);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		System.out.println(" We\boutput \b f = "  +  f);
		
		
		
	} 
}
