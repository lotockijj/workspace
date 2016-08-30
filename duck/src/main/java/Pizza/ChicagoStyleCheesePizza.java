package Pizza;

public class ChicagoStyleCheesePizza extends Pizza {
	
	public ChicagoStyleCheesePizza() {
		name = "Chicago Style Deep Dish Cheese Pizza";
		dough.setName("Extra Thick Crust Dough");
		sauce.setName( "Plum Tomato Sauce");
		//toppings.add("Shredded Mozzarella Cheese");
		//toppings.add("Olives");
		//toppings.add("Corn");
	}
	
	@Override
	public void cut() {
		System.out.println("Cutting the pizza into square slices!!!");
	}

	@Override
	void prepare() {
		// TODO Auto-generated method stub
		
	}
	
}