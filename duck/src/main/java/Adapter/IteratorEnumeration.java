package Adapter;

import java.util.Enumeration;
import java.util.Iterator;

public class IteratorEnumeration<E> implements Enumeration<E>{
	
	Iterator<?> iterator;
	
	public IteratorEnumeration(Iterator<?> iterator){
		this.iterator = iterator;
	}

	public boolean hasMoreElements() {
		return iterator.hasNext();
	}

	public E nextElement() {
		return (E) iterator.next();
	}
	
	public void remove(){
		iterator.remove();
	}

}
