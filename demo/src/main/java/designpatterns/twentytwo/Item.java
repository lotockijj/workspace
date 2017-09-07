package designpatterns.twentytwo;

import java.math.BigDecimal;

public class Item {
	private String name;
	private BigDecimal price;
	private float weight;
	private float capacity;

	public Item(String name, BigDecimal price, float weight, float capacity) {
		this.name = name;
		this.price = price;
		this.weight = weight;
		this.capacity = capacity;
	}

	public boolean isValid(){
		if(capacity < 25000 && weight < 25000){
			return true;
		} else {
			return false;
		}
	}

	public boolean save(){
		if(isValid()){
			System.out.println("Item " + getName() + " saved. " + "$" + getPrice() + " #" +
		getWeight() + "pd" + ", " + getCapacity());
			return true;
		} else {
			return false;
		}
	}

	public String getName() {
		return name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public float getWeight() {
		return weight;
	}

	public float getCapacity() {
		return capacity;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public void setCapacity(float capacity) {
		this.capacity = capacity;
	}
	
	

}
