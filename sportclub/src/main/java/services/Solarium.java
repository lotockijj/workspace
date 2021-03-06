package services;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;

import dao.DaoServicesTrack;
import decorator.Price;
import tracks.ServicesTrack;

public class Solarium implements Price{
	private Price price;
	private ServicesTrack track;
	private DaoServicesTrack dao;
	
	public Solarium() throws SQLException{
		track = new ServicesTrack();
		track.setTakeSolyariy(true);
		dao = new DaoServicesTrack();
	}
	
	public Solarium(Price price) {
		this.price = price;
	}
	
	@Override
	public BigDecimal getPrice() {
		return price.getPrice().add(new BigDecimal(150));
	}

	@Override
	public String getDescription() {
		return price.getDescription() + "Солярій: " + 150 + " гривень.\n";
	}

	@Override
	public void setPrice(Date startDate) {
	}

	@Override
	public void updateTrack(int id) {
		dao.updateServicesTrack(track, id);
	}
	
}
