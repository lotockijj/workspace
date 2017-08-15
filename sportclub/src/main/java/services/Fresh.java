package services;

import java.math.BigDecimal;
import java.sql.Date;

import decorator.Price;
import decorator.ServiceDecorator;

public class Fresh  extends ServiceDecorator{
	private Price price;
	
	public Fresh(Price price) {
		this.price = price;
	}
	
	@Override
	public BigDecimal getPrice() {
		return price.getPrice().add(new BigDecimal(50));
	}

	@Override
	public String getDescription() {
		return price.getDescription() + "Фреш: " + 50 + " гривень.\n";
	}

	@Override
	public void setPrice(Date startDate) {
	}
	
}
