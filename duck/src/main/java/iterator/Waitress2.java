package iterator;

import java.util.Iterator;

public class Waitress2 {
	
	Menu pancakeHouseMenu;
	Menu dinerMenu;
	
	public Waitress2(Menu pancakeHouseMenu, Menu dinerMenu) {
		this.pancakeHouseMenu = pancakeHouseMenu;
		this.dinerMenu = dinerMenu;
	}

	public void printMenu(){
		Iterator pancakeIterator = (Iterator) pancakeHouseMenu.createIterator();
		Iterator dinerIterator = (Iterator) dinerMenu.createIterator();
		System.out.println("MENU\n----\nBREAKFAST");
		printMenu(pancakeIterator);
		System.out.println("\nLunch");
		printMenu(dinerIterator);
		
	}

	private void printMenu(Iterator iterator) {
		while(iterator.hasNext()){
			MenuItem menuItem = (MenuItem) iterator.next();
			System.out.print(menuItem.getName() + ", ");
			System.out.print(menuItem.getPrice() + " -- ");
			System.out.println(menuItem.getDescription());
		}
	}
	
}
