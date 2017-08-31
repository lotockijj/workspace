package designpatterns.ten;

public class ConsoleLogger implements Logger {
	private static final ConsoleLogger INSTANCE = new ConsoleLogger();
	
	private ConsoleLogger(){
	}
	
	public static ConsoleLogger getInstance(){
		return INSTANCE;
	}
	
	public void log(String msg) {
		System.out.println(msg);
	}

}
