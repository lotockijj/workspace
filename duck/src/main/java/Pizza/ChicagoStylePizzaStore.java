package Pizza;

public class ChicagoStylePizzaStore extends PizzaStore{

	@Override
	protected Pizza createPizza(String item) {
		if (item.equals("cheese")) {
			return new ChicagoStyleCheesePizza();
		} else if (item.equals("pepperoni")) {
			return new ChicagoStylePepperoniPizza();
		} else if (item.equals("clam")) {
			return new ChicagoStyleClamPizza();
		} else if (item.equals("veggie")) {
			return new ChicagoStyleVeggiePizza();
		} else return null;
	}
}
