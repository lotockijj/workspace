package designpatterns.eightenn;

import designpatterns.fiftinth.Item;
import designpatterns.fiftinth.Product;

public interface VisitorIntr {
	
	public void visit(Product product);
	public void visit(Item item);
}
