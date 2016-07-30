package simple.date.format;


//Demonstrate DateTimeFormatter.

import java.time.*;
import java.time.format.*;

class DateTimeDemo2 {

	public static void main(String args[]) {
		LocalDate curDate = LocalDate.now();
		System.out.println(curDate.format(
				DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
		LocalTime curTime = LocalTime.now();
		System.out.println(curTime.format(
				DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT)));
	}
}
