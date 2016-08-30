package iterator;

import java.util.ArrayList;

public class PancakeHouseMenu implements Menu{
	
	ArrayList menuItems;

	public PancakeHouseMenu() {
		menuItems = new ArrayList();
		
		addItem("K&B’s Pancake Breakfast",
				"Pancakes with scrambled eggs, and toast",
				true,
				2.99);
		addItem("Regular Pancake Breakfast",
				"Pancakes with fried eggs, sausage",
				false,
				2.99);
		addItem("Blueberry Pancakes",
				"Pancakes made with fresh blueberries",
				true,
				3.49);
		addItem("Waffles",
				"Waffles, with your choice of blueberries or strawberries",
				true,
				3.59);
		
	}

	private void addItem(String name, String description, boolean vegetarian, double price) {
		MenuItem meneItem = new MenuItem(name, description, vegetarian, price);
		menuItems.add(meneItem);
	}
	
	public ArrayList getMenuItems(){
		return menuItems;
	}

	public Iterator createIterator() {
		// TODO Auto-generated method stub
		return null;
	}

//	public iterator.Iterator createIterator() {
//		return (iterator.Iterator) new PancakeHouseMenuIterator(menuItems);
//	}
	
	
	
//	public Iterator createIterator(){
//		return  menuItems.iterator();
//		//return new PancakeHouseMenuIterator(menuItems);
//	}
	// other menu methods here
}
