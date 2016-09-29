package decorator;

public class Soy extends CondimentDecorator {
	
	Beverage beverage;
	
	public Soy(Beverage beverage) {
		this.beverage = beverage;
	}
	
	public Size getSize(){
		return beverage.getSize();
	}
	
	public String getDescription() {
		return beverage.getDescription() + ", Soy";
	}
	
	public double cost() {
		double cost = beverage.cost();
		if(getSize() == Size.TALL){
			cost += .10;
		} else if(getSize() == Size.GRANDE){
			cost += .15;
		} else if(getSize() == Size.VENTI){
			cost += .20;
		}
		
		return cost;
	}

}