package composite;

public class MenuTestDrive2 {

	public static void main(String[] args) {
		MenuComponent pancakeHouseMenu = new Menu("PANCAKE HOUSE MENU", "Breakfast");
		MenuComponent dinerMenu = new Menu("DINER MENU", "Lunch");
		MenuComponent cafeMenu = new Menu("CAFE MENU", "Dinner");
		MenuComponent dessertMenu = new Menu("DESSERT MENU", "Dessert of course");
		
		MenuComponent allMenus = new Menu("ALL MENUS", "All menus combined");
		
		allMenus.add(pancakeHouseMenu);
		allMenus.add(dinerMenu);
		allMenus.add(cafeMenu);
		
		dinerMenu.add(new MenuItem("Pasta",
				"Spaghetti with Marinara Sauce, and a slice of sourdough bread",
				true, 3.89));
		dinerMenu.add(dessertMenu);
		dessertMenu.add(new MenuItem("Apple Pie",
				"Apple pie with a flakey crust, topped with vanilla icecream",
				true, 1.59));
		
		Waitress2 waitress2 = new Waitress2(allMenus);
		waitress2.printMenu();
		waitress2.printVegetarianMenu();
	}

}
