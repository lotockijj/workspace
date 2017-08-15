package services;

import java.math.BigDecimal;
import java.sql.Date;

import decorator.Price;
import decorator.ServiceDecorator;

public class Solarium extends ServiceDecorator{
	private Price price;
	
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
	
}
