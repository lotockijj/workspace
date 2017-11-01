package ekkel._17_10_2017;

public class Leaf {
	int i = 0;
	
	Leaf increment(){
		i++;
		return this;
	}
	
	public void print(){
		System.out.println(i);
	} 
	
	public static void main(String[] args) {
		new Leaf().increment().increment().increment().increment().print();
	}
}
