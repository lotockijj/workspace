package efective.java.person;

import java.sql.Date;
import java.util.Calendar;
import java.util.TimeZone;

public class Person {
	
	private Date birthDate;
	// Other fields, methods, and constructor omitted
	// DON'T DO THIS!
	public boolean isBabyBoomer() {
		// Unnecessary allocation of expensive object
		Calendar gmtCal =
				Calendar.getInstance(TimeZone.getTimeZone("GMT"));
		gmtCal.set(1946, Calendar.JANUARY, 1, 0, 0, 0);
		java.util.Date boomStart = gmtCal.getTime();
		gmtCal.set(1965, Calendar.JANUARY, 1, 0, 0, 0);
		java.util.Date boomEnd = gmtCal.getTime();
		return birthDate.compareTo(boomStart) >= 0 &&
				birthDate.compareTo(boomEnd) < 0;
	}
}