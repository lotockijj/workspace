package abonnements;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

import decorator.ServiceDecorator;
import tracks.AbonnementsTrack;

public class AbonnementsAllDayUnlimited extends ServiceDecorator{
	private BigDecimal cost = new BigDecimal(490);
	private AbonnementsTrack track;
	
	public AbonnementsAllDayUnlimited(){
		track = new AbonnementsTrack();
		track.setBaseAllDay(true);
	}

	@Override
	public String getDescription() {
		return "- Зал(весь день) цілий місяць безлім: "  + cost + " гривень.\n";
	}

	@Override
	public BigDecimal getPrice() {
		return cost;
	}
	
}
