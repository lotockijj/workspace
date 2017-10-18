package designpatterns.visitor;

import designpatterns.composite.Item;
import designpatterns.composite.Product;

public interface VisitorIntr {
	
	public void visit(Product product);
	public void visit(Item item);
}
