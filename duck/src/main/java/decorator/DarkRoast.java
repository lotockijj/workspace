package decorator;

public class DarkRoast extends Beverage {

	public DarkRoast(){
		description = "Most Excellent Dark Roas";
	}

	@Override
	public double cost() {
		return .99 + super.cost();
	}
	

}
