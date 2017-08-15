package designpatterns.second.third;

public class OrderManager {
	private int orderID = 0;
	
	private static OrderManager instance = null;
	
	private OrderManager(){
	}
	
	public static OrderManager getInstance(){
		if(instance == null){
			instance = new OrderManager();
		}
		return instance;
	}
	
	private int getOrderID(){
		orderID++;
		return orderID;
	}
	
	public void saveOrder(String item, int gty){
		int ID = getOrderID();
		System.out.println("Order id: " + ID + ". Item: " + item + ", Qty " + gty + " is saved.");
	}
	
	public static void main(String[] args) {
		OrderManager.getInstance().saveOrder("First  item", 44445555);
		OrderManager.getInstance().saveOrder("Second item", 11112222);
		OrderManager.getInstance().saveOrder("Third  item", 66667777);
	}
}
