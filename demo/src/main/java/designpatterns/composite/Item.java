package designpatterns.composite;

import java.math.BigDecimal;

import designpatterns.visitor.Price;
import designpatterns.visitor.VisitorIntr;

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
