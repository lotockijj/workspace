package Simple;

public class HelloRunable implements Runnable{
	@Override
	public void run() {
		System.out.println("Hello World!!!");// TODO Auto-generated method stub
	}
	public static void main(String[] args){
		(new Thread(new HelloRunable())).start(); 
	}

}
