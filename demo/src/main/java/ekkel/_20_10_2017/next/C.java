package ekkel._20_10_2017.next;

public class C extends A {
	
	public C(int i) {
		super(i);
	}

	B b = new B("Instance in C class");
	
	public static void main(String[] args) {
		C c = new C(3);
		
		
		System.out.println(c.toString());
	}
}
