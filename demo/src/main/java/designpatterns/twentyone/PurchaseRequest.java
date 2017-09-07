package designpatterns.twentyone;

public class PurchaseRequest {
	private int id;
	private String description;
	private double amount;

	public PurchaseRequest(int id, String description, double amount) {
		this.id = id;
		this.description = description;
		this.amount = amount;
	}
	
	public double getAmount(){
		return amount;
	}
	
	public String toString(){
		return id + " " + description;
	} 
}
