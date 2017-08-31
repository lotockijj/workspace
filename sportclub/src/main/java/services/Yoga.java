package services;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;

import dao.DaoServicesTrack;
import decorator.Price;
import tracks.ServicesTrack;

public class Yoga implements Price{
	private Price price;
	private ServicesTrack track;
	private DaoServicesTrack dao;
	
	public Yoga() throws SQLException{
		track = new ServicesTrack();
		track.setTakeYoga(true);
		dao = new DaoServicesTrack();
	}
	
	public Yoga(Price price) {
		this.price = price;
	}
	@Override
	public BigDecimal getPrice() {
		return price.getPrice().add(new BigDecimal(35));
	}

	@Override
	public String getDescription() {
		return price.getDescription() + "Йога: " + 35 + " гривень.\n";
	}

	@Override
	public void setPrice(Date startDate) {
	}

	@Override
	public void updateTrack(int id) {
		dao.updateServicesTrack(track, id);
	}
	
}
