package Pizza;

public class NYStyleCheesePizza extends Pizza {
	
	public NYStyleCheesePizza() {
		name = "NY Style Sauce and Cheese Pizza";
		dough.setName("Thin Crust Dough");
		sauce.setName("Marinara Sauce");
		toppings.add("Grated Reggiano Cheese");
		toppings.add("My STRONG PEPPER");
	}

	@Override
	void prepare() {
		// TODO Auto-generated method stub
		
	}

}
