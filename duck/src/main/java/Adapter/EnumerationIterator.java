package Adapter;

import java.util.Enumeration;
import java.util.Iterator;

public class EnumerationIterator implements Iterator{
	
	Enumeration enumaration;
	
	public EnumerationIterator(Enumeration enumaration) {
		this.enumaration = enumaration;
	}
	
	public boolean hasNext() {
		return enumaration.hasMoreElements();
	}
	
	public Object next() {
		return enumaration.nextElement();
	}
	
	public void remove() {
		throw new UnsupportedOperationException();
	}
	
}
