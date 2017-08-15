package abonnements;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

import decorator.ServiceDecorator;
import tracks.AbonnementsTrack;

public class AbonnementsAllDay12Times extends ServiceDecorator{
	private BigDecimal cost = new BigDecimal(420);
	private AbonnementsTrack track;
	
	public AbonnementsAllDay12Times(){
		track = new AbonnementsTrack();
		track.setBaseAllDay(true);
	}

	public AbonnementsTrack getTrack() {
		return track;
	}

	@Override
	public String getDescription() {
		return "Зал(весь день) 12 разів: "  + cost + " гривень.\n";
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
