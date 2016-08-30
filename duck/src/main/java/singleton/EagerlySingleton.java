package singleton;

public class EagerlySingleton {
	
	private static EagerlySingleton uniqueInstance = new EagerlySingleton();
	
//	The JVM guarantees that the instance will be created before any thread
//	accesses the static uniqueInstance variable.
	
	private EagerlySingleton() {
	}
	
	public static EagerlySingleton getInstance() {
		return uniqueInstance;
	}
}