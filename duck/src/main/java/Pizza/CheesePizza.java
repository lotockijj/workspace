package Pizza;

import Pizza.Ingridients.PizzaIngredientFactory;

public class CheesePizza extends Pizza {
	
	PizzaIngredientFactory ingredientFactore;
	
	public CheesePizza(PizzaIngredientFactory ingredientFactory) {
		this.ingredientFactore = ingredientFactory;
	}
	@Override
	void prepare() {
		System.out.println("Preparing " + name);
		dough = ingredientFactore.createDough();
		sauce = ingredientFactore.createSauce();
		cheese = ingredientFactore.createCheese();
	}
	
	

}
