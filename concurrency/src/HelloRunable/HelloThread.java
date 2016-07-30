package HelloRunable;

public class HelloThread extends Thread{
	public void run(){
		System.out.println("Hello from a Thread!");
	}
	public static void main(String[] args){
		(new HelloThread()).start(); 
	}

}
