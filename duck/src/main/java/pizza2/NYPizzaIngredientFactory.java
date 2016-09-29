package pizza2;

public class NYPizzaIngredientFactory implements PizzaIngredientFactory{

	public Dough createDough() {
		return new ThinCrustDough();
	}

	public Veggies[] createVeggies() {
		Veggies veggies[] = { new Garlic()};
		return veggies;
	}

}
