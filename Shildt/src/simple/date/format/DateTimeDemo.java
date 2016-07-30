package simple.date.format;

//A simple example of LocalDate and LocalTime.

import java.time.*;

class DateTimeDemo {
	
	public static void main(String args[]) {
		LocalDate curDate = LocalDate.now();
		System.out.println(curDate);
		LocalTime curTime = LocalTime.now();
		System.out.println(curTime);
		LocalDateTime curDateTime = LocalDateTime.now();
		System.out.println(curDateTime);
	}
}