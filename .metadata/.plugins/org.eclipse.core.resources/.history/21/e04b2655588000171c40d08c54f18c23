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
	
	@Override
	public void setPrice(Date startDate) {
		LocalDate start = startDate.toLocalDate();
		LocalDate today = LocalDate.now();
		if(Period.between(start, today).getYears() >= 10){
			cost = cost.multiply(new BigDecimal(0.95));
			cost = cost.setScale(2, RoundingMode.FLOOR);
		}
	}

}
