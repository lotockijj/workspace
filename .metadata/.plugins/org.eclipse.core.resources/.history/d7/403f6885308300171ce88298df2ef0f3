package abonnements;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;

import dao.DaoAbonTrack;
import decorator.Price;
import tracks.AbonnementsTrack;

public class AbonnementsAllDay12Times extends Price{
	private BigDecimal cost = new BigDecimal(420);
	private AbonnementsTrack track;
	private DaoAbonTrack dao;
	
	public AbonnementsAllDay12Times() throws FileNotFoundException, IOException, SQLException{
		track = new AbonnementsTrack();
		track.setBaseAllDay(true);
		dao = new DaoAbonTrack();
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
	
	@Override
	public void updateTrack(int id){
		dao.updateAbonnementsTrack(track, id);
	}

	
}