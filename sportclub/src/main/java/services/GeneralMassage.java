package services;

import java.math.BigDecimal;
import java.sql.Date;

import decorator.Price;
import decorator.ServiceDecorator;

public class GeneralMassage extends ServiceDecorator{
	private Price price;
	
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
	
}
