package eleks.sportclub.helpful;

import java.util.Date;

public class TryDate {

	public static void main(String[] args) throws InterruptedException {
		Date firstDate = new Date();
		for(int i = 0; i < 1000000; i++){
			i++; i--;
		}
		Date secondDate = new Date();
		long value = secondDate.getTime() - firstDate.getTime();
		System.out.println(value);
	}
}
