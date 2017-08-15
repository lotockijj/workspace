package eleks.sportclub.helpful;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class SqlDate {

	public static Date createSqlDate(String string) throws ParseException {
		DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
		return new Date(df.parse(string).getTime());
	}
	
	
}
