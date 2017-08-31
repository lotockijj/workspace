package decorator;

import java.math.BigDecimal;
import java.sql.Date;

public interface Price {
	
	BigDecimal getPrice();
	
	String getDescription();
	
	void setPrice(Date startDate);
	
	void updateTrack(int id);
	
}