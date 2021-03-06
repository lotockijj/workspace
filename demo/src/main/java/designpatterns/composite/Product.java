package designpatterns.composite;

import java.math.BigDecimal;
import java.util.Enumeration;
import java.util.Vector;

import designpatterns.visitor.Price;
import designpatterns.visitor.VisitorIntr;

public class Product extends ProductComponent implements Price{
	Vector<ProductComponent> productContext;
	@SuppressWarnings("unused")
	private BigDecimal price;
	
	public Product(String name, BigDecimal price) {
		super(name);
		this.price = price;
		productContext = new Vector<>();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void addComponent(ProductComponent product) throws CompositeException{
		productContext.add(product);
	}
	
	public ProductComponent getComponent(int componentNum) throws CompositeException{
		return productContext.elementAt(componentNum);
	}
	
	@Override
	public BigDecimal getPrice() {
		BigDecimal theWholePrice = new BigDecimal(0);
		Enumeration<ProductComponent> e = productContext.elements();
		while(e.hasMoreElements()){
			theWholePrice = theWholePrice.add(e.nextElement().getPrice());
		}
		return theWholePrice;
	}

	@Override
	public void accept(VisitorIntr v) {
		v.visit(this);
	}

}
