package concurrency;

public class SleepMessages {

	public static void main(String[] args) throws InterruptedException {
		String a[] = {"Mares eat oat", "Does eat oats", "Little lambs eat ive", "A kid eat ive too"}; 
		for (int i = 0; i < a.length; i++) {
		    try {
		        Thread.sleep(4000);
		    } catch (InterruptedException e) {
		        return;
		    }
		    System.out.println(a[i]);
		}
	}
}
