package designpatterns.visitor;

import designpatterns.composite.Item;
import designpatterns.composite.Product;

public class PriceVisitor implements VisitorIntr {
	
	@Override
	public void visit(Product product) {
		System.out.println(product.getPrice());
	}

	@Override
	public void visit(Item item) {
		System.out.println(item.getPrice());
	}

}
