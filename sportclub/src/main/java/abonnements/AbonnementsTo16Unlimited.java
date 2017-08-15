package abonnements;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

import decorator.ServiceDecorator;
import tracks.AbonnementsTrack;

public class AbonnementsTo16Unlimited extends ServiceDecorator {
	private BigDecimal cost = new BigDecimal(450);
	private AbonnementsTrack track;
	
	public AbonnementsTo16Unlimited() {
		track = new AbonnementsTrack();
		track.setBase(true);
	}
	
	public AbonnementsTrack getTrack(){
		return track;
	}
	
	@Override
	public String getDescription() {
		return  "Зал(зранку до 16:00) цілий місяць безлім: "  + cost + " гривень.\n";
	}

	@Override
	public BigDecimal getPrice() {
		return cost;
	}

}
