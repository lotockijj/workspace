package services;

import java.math.BigDecimal;
import java.sql.SQLException;

import dao.DaoServicesTrack;
import decorator.Price;
import tracks.ServicesTrack;

public class Sauna implements Price{
	private Price price;
	private ServicesTrack track;
	private DaoServicesTrack dao;
	
	public Sauna() throws SQLException{
		track = new ServicesTrack();
		dao = new DaoServicesTrack();
	}
	
	public Sauna(Price price) {
		this.price = price;
	}
	
	@Override
	public BigDecimal getPrice() {
		return price.getPrice().add(new BigDecimal(400));
	}

	@Override
	public String getDescription() {
		return price.getDescription() + "Сауна: " + 400 + " гривень.\n";
	}

	@Override
	public void setPrice(java.sql.Date startDate) {
	}

	@Override
	public void updateTrack(int id) {
		dao.updateServicesTrack(track, id);
	}
	

}
