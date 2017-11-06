package epam.roman.exception;

/**
 * 1. Add custom exceptions to projects "Fibonacci numbers" and "Battle of droids".
 * 2. Create your own AutoCloseable class, and try how it works in try-with-resources.
 * 3. Throw some exception in close() method of your AutoClosable class and watch what will happen.
 */

public class MyClosable implements AutoCloseable {

	@Override
	public void close() throws Exception {
		 System.out.println("Closing resource. ");
		 throw new NullPointerException();
	}
	
	public void open(){
		System.out.println("Open resource. ");
	}

	public static void main(String[] args){
		try(MyClosable myClosable = new MyClosable()){
			myClosable.open();
		} catch ( Exception e){
			e.printStackTrace();
		}
	}
}
