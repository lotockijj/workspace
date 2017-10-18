package designpatterns.ten;

public class HelloWorld extends Thread{
	private int count;
	public static int countSt = 0;

	public int incrementCount(){
		countSt++;
		return count++;
	}

	public void run(){
		incrementCount();
	}

	public int getCount(){
		return count;
	}
	
	public static int getCountStatic(){
		return countSt;
	}

	public static void main(String []args) throws InterruptedException{
		HelloWorld h = new HelloWorld();
		h.start();
		HelloWorld h2 = new HelloWorld();
		h2.start();
		System.out.println(h.getCount() + " | " + getCountStatic());
		System.out.println(h2.getCount() + " | " + getCountStatic());
	}
}