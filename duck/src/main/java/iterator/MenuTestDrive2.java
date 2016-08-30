package iterator;

public class MenuTestDrive2 {
	
	public static void main(String args[]) {
		PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
		DinerMenu dinerMenu = new DinerMenu();
		CafeMenu cafeMenu = new CafeMenu();
		Waitress3 waitress = new Waitress3(pancakeHouseMenu, dinerMenu, cafeMenu);
		waitress.printMenu();
	}
}