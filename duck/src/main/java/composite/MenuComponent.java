package composite;

import java.util.Iterator;

public abstract class MenuComponent {
	
	public void add(MenuComponent menuComponent){     //We’ve grouped together the
		throw new UnsupportedOperationException();    //“composite” methods - that is,
	}                                                 //methods to add, remove and get
	public void remove(MenuComponent menuComponent){  //MenuComponents.
		throw new UnsupportedOperationException();
	}
	public MenuComponent getChild(int i){
		throw new UnsupportedOperationException();
	}
	
	public String getName(){
		throw new UnsupportedOperationException();
	}
	public String getDescription(){
		throw new UnsupportedOperationException();
	}
	public double getPrice(){
		throw new UnsupportedOperationException();
	}
	public boolean isVegetarian(){
		throw new UnsupportedOperationException();
	}
	public void print(){
		throw new UnsupportedOperationException();
	}
	public abstract Iterator createIterator();
}
