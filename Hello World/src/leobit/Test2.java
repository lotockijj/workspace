package leobit;

public class Test2 {
	
	public void print(Object o){
		System.out.println("Exception");
	}

	public static void main(String[] args) {
		
		Object o = new RuntimeException();
		Test2 t = new Test2();
	    t.print(o);
	    t.print(null);

	}

}
