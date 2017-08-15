package services;

import java.math.BigDecimal;
import java.sql.Date;

import decorator.Price;
import decorator.ServiceDecorator;

public class OneTimeSlippers  extends ServiceDecorator{
	private Price price;
	
	public OneTimeSlippers(Price price) {
		this.price = price;
	}
	
	@Override
	public BigDecimal getPrice() {
		return price.getPrice().add(new BigDecimal(5));
	}

	@Override
	public String getDescription() {
		return price.getDescription() + "Одноразові тапочки: " + 5 + " гривень.\n";
	}

	@Override
	public void setPrice(Date startDate) {
	}
	
}
