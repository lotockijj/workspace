package services;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;

import dao.DaoServicesTrack;
import decorator.Price;
import tracks.ServicesTrack;

public class Krosfit extends Price{
	private Price price;
	private ServicesTrack track;
	private DaoServicesTrack dao;
	
	public Krosfit() throws SQLException{
		track = new ServicesTrack();
		track.setTakeKrosfit(true);
		dao = new DaoServicesTrack();
	}
	
	public Krosfit(Price price) {
		this.price = price;
	}
	
	@Override
	public BigDecimal getPrice() {
		return price.getPrice().add(new BigDecimal(30));
	}

	@Override
	public String getDescription() {
		return price.getDescription() + "Кросфіт: " + 30 + " гривень.\n";
	}

	@Override
	public void setPrice(Date startDate) {
	}

	@Override
	public void updateTrack(int id) {
		dao.updateServicesTrack(track, id);
	}
	
}
