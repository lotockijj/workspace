package designpatterns.fiftinth;

import java.math.BigDecimal;

import designpatterns.eightenn.VisitorIntr;

public abstract class ProductComponent {
	String name;
	
	public ProductComponent(String name) {
		this.name = name;
	}
	
	public void addComponent(ProductComponent product) throws CompositeException{
		throw new CompositeException("Invalid operation. Not supported.");
	}
	
	public ProductComponent getComponent(int componentNum) throws CompositeException{
		throw new CompositeException("Invalid operation. Not supported.");
	}
	
	public abstract BigDecimal getPrice();

	public abstract void accept(VisitorIntr visitor);
	
}
