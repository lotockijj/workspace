package composite;

import java.util.ArrayList;
import java.util.Iterator;

public class Menu extends MenuComponent{ 

	ArrayList menuComponents = new ArrayList();
	String name;
	String description;
	Iterator iterator = null;

	public Menu(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public void add(MenuComponent menuComponent){
		menuComponents.add(menuComponent);
	}
	public void remove(MenuComponent menuComponent){
		menuComponent.remove(null);
	}
	public MenuComponent getChild(int i) {
		return (MenuComponent)menuComponents.get(i);
	}
	public String getName(){
		return name;
	}
	public String getDescription(){
		return description;
	}

	public void print(){
		System.out.print("\n" + getName());
		System.out.println(", " + getDescription());
		System.out.println("----------------------");
		Iterator iterator = menuComponents.iterator();
		while(iterator.hasNext()){
			MenuComponent menuComponent = (MenuComponent) iterator.next();
			menuComponent.print();
		}	
	}

	@Override
	public Iterator createIterator() {
		if(iterator == null){
			iterator = new CompositeIterator(menuComponents.iterator());
		}
		return iterator; 
	}


}
