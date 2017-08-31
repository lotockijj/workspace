package services;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;

import dao.DaoServicesTrack;
import decorator.Price;
import tracks.ServicesTrack;

public class GeneralMassage extends Price{
	private Price price;
	private ServicesTrack track;
	private DaoServicesTrack dao;
	
	public GeneralMassage() throws SQLException{
		track = new ServicesTrack();
		track.setTakeGeneralMassage(true);
		dao = new DaoServicesTrack();
	}
	
	public GeneralMassage(Price price) {
		this.price = price;
	}
	
	@Override
	public BigDecimal getPrice() {
		return price.getPrice().add(new BigDecimal(200));
	}

	@Override
	public String getDescription() {
		return price.getDescription() + "Загальний масаж: " + 200 + " гривень.\n";
	}

	@Override
	public void setPrice(Date startDate) {
	}

	@Override
	public void updateTrack(int id) {
		dao.updateServicesTrack(track, id);
	}
	
}
