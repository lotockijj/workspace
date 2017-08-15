package services;

import java.math.BigDecimal;
import java.sql.Date;

import decorator.Price;
import decorator.ServiceDecorator;

public class AttendingGym extends ServiceDecorator{
	private Price price;
	
	public AttendingGym(Price price) {
		this.price = price;
	}
	
	@Override
	public BigDecimal getPrice() {
		return price.getPrice().add(new BigDecimal(35));
	}

	@Override
	public String getDescription() {
		return price.getDescription() + "Відвідування залу: " + 35 + " гривень.\n";
	}

	@Override
	public void setPrice(Date startDate) {
	}
	
}
