package iterator;

public class MenuTestDrive {

	public static void main(String[] args) {
		
		PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
		DinerMenu dinerMenu = new DinerMenu();
		CafeMenu cafeMenu = new CafeMenu();
		
		Waitress waitress = new Waitress(pancakeHouseMenu, dinerMenu);
		
		waitress.printMenu();
		
		System.out.println("WAITRESS3 ---- \n ");
		Waitress3 waitress3 = new Waitress3(pancakeHouseMenu, dinerMenu, cafeMenu);
		waitress3.printMenu();
	}

}
