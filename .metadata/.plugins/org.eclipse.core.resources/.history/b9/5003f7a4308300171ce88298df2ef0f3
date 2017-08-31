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

public class AbonnementsTo16Unlimited extends Price{
	private BigDecimal cost = new BigDecimal(450);
	private AbonnementsTrack track;
	private DaoAbonTrack dao;
	
	public AbonnementsTo16Unlimited() throws FileNotFoundException, IOException, SQLException {
		track = new AbonnementsTrack();
		track.setBase(true);
		dao = new DaoAbonTrack();
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
