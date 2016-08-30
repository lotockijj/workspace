package yakov.fain.lesson20;

public class Portfolio3 extends Thread {
	
	public Portfolio3 (String str) {
		super(str);
	}
	
	public void run() {
		try{
			for (int i=0; i<10;i++){
				sleep (700); // Sleep for 700 milliseconds
				System.out.println( "You have " + (500 + i) +
						" shares of IBM");
			}
		}catch(InterruptedException e ){
			System.out.println(Thread.currentThread().getName()
					+ e.toString());
		}
	}
}