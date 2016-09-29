package pizza2;

public class PizzaTestDrive2 {
	
	public static void main(String[] args) {

		PizzaStore nyStore = new NYPizzaStore();
		Pizza pizza = nyStore.orderPizza("cheese");
		System.out.println("Ethan ordered a " + pizza + "\n");

	}

}