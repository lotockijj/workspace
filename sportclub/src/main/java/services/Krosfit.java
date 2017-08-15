package services;

import java.math.BigDecimal;
import java.sql.Date;

import decorator.Price;
import decorator.ServiceDecorator;

public class Krosfit extends ServiceDecorator{
	private Price price;
	
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
	
}
