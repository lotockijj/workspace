package decorator;

public abstract class Beverage {
	
	public static final double TALL = .10;
	public static final double GRANDE = .15;
	public static final double VENTI = .20;
	
	String description = "Unknown Beverage";
	
	private double milkCost;
	private double soyCost;
	private double mochaCost;
	private double whipCost;
	
	public double getMilkCost() {
		return milkCost;
	}

	public void setMilkCost(double milkCost) {
		this.milkCost = milkCost;
	}

	public double getSoyCost() {
		return soyCost;
	}

	public void setSoyCost(double soyCost) {
		this.soyCost = soyCost;
	}

	public double getMochaCost() {
		return mochaCost;
	}

	public void setMochaCost(double mochaCost) {
		this.mochaCost = mochaCost;
	}

	public double getWhipCost() {
		return whipCost;
	}

	public void setWhipCost(double whipCost) {
		this.whipCost = whipCost;
	}

	
	public String getDescription() {
		return description;
	}
	
	public double cost(){
		double condimentCost = 0.0;
		if(hasMilk()){
			condimentCost += milkCost;
		}
		if(hasSoy()){
			condimentCost += soyCost;
		}
		if(hasMocha()){
			condimentCost += mochaCost;
		}
		if(hasWhip()){
			condimentCost += whipCost;
		}
		return condimentCost;
	}

	private boolean hasWhip() {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean hasMocha() {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean hasSoy() {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean hasMilk() {
		// TODO Auto-generated method stub
		return false;
	}

	public double getSize() {
		return setSize(0);
	}
	
	public double setSize(double size){
		return cost() + size;
	}

}