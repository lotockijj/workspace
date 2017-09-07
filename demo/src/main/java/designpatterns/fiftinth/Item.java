package designpatterns.fiftinth;

import java.math.BigDecimal;

import designpatterns.eightenn.Price;
import designpatterns.eightenn.VisitorIntr;

public class Item extends ProductComponent implements Price{
	private BigDecimal price;
	
	public Item(String name, BigDecimal price) {
		super(name);
		this.price = price;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public BigDecimal getPrice() {
		return price;
	}

	@Override
	public void accept(VisitorIntr v) {
		v.visit(this);
	}
	
}
