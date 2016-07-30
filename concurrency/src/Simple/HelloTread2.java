package Simple;

public class HelloTread2 extends Thread{
	public void doSomething(){
		System.out.println("Hello from  a thread");
	}
	public void run(){
		System.out.println("Hello World");
	}
	public static void run2(){
		System.out.println("Hello");
	}
	public static void main(String[] args){
		(new HelloTread2()).start();
		HelloTread2 a = new HelloTread2(); 
		a.doSomething();
		HelloTread2.run2();
		
	}

}
