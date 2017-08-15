package services;

import java.math.BigDecimal;

import decorator.Price;
import decorator.ServiceDecorator;

public class Sauna extends ServiceDecorator {
	private Price price;
	
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
	

}
