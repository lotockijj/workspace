package decorator;

public abstract class Beverage {
	
	public enum Size { TALL, GRANDE, VENTI };
	Size size = Size.TALL;
	
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
		return true;
	}

	private boolean hasMocha() {
		return true;
	}

	private boolean hasSoy() {
		return true;
	}

	private boolean hasMilk() {
		return true;
	}

	public void setSize(Size size){
		this.size = size;
	}

	public Size getSize() {
		return this.size;
	}

}