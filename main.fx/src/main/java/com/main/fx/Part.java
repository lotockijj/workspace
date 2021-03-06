package com.main.fx;

public abstract class Part {
	String name;
	int partID;
	double price;
	int instock;
	int min;
	int max;
	
	public String getName() {
		return name;
	}
	public int getPartID() {
		return partID;
	}
	public double getPrice() {
		return price;
	}
	public int getInstock() {
		return instock;
	}
	public int getMin() {
		return min;
	}
	public int getMax() {
		return max;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPartID(int partID) {
		this.partID = partID;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void setInstock(int instock) {
		this.instock = instock;
	}
	public void setMin(int min) {
		this.min = min;
	}
	public void setMax(int max) {
		this.max = max;
	}
	
	@Override
	public String toString() {
		return "Part [name=" + name + ", partID=" + partID + ", price=" + price + ", instock=" + instock + ", min="
				+ min + ", max=" + max + "]";
	}
	
}
