package pizza2;

public class CheesePizza extends Pizza {
	
	PizzaIngredientFactory ingredientFactory;

	
	public CheesePizza(PizzaIngredientFactory ingredientFactory){
		this.ingredientFactory = ingredientFactory;
	}

	@Override
	void prepare() {
		System.out.println("Preparing " + name);
		dough = ingredientFactory.createDough();
		veggies = ingredientFactory.createVeggies();
	}
	
}
