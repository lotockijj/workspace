package abonnements;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

import dao.DaoAbonTrack;
import decorator.Price;
import tracks.AbonnementsTrack;

public class AbonnementsTo16and12Times implements Price{
	private BigDecimal cost = new BigDecimal(390);
	private AbonnementsTrack track;
	private DaoAbonTrack dao;
	
	public AbonnementsTo16and12Times(){
		track = new AbonnementsTrack();
		track.setBaseAllDay(true);
	}
	
	public AbonnementsTrack getTrack() {
		return track;
	}
	
	@Override
	public String getDescription() {
		return "Зал(зранку до 16:00) 12 разів: "  + cost + " гривень.\n";
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

	@Override
	public void updateTrack(int id) {
		dao.updateAbonnementsTrack(track, id);
	}
	
}
