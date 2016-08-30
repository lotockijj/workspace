package Pizza.Ingridients;

import Pizza.ChicagoStyleCheesePizza;
import Pizza.ChicagoStyleClamPizza;
import Pizza.ChicagoStylePepperoniPizza;
import Pizza.ChicagoStyleVeggiePizza;
import Pizza.Pizza;
import Pizza.PizzaStore;

public class ChicagoPizzaStore extends PizzaStore{

	@Override
	protected Pizza createPizza(String item) {
		if (item.equals("cheese")) {
			return new ChicagoStyleCheesePizza();
		} else if (item.equals("veggie")) {
			return new ChicagoStyleVeggiePizza();
		} else if (item.equals("clam")) {
			return new ChicagoStyleClamPizza();
		} else if (item.equals("pepperoni")) {
			return new ChicagoStylePepperoniPizza();
		} else return null;
	}
}