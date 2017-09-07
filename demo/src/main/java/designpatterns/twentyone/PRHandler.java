package designpatterns.twentyone;

public abstract class PRHandler {
	private PRHandler nextHandler;
	private String handlerName;
	
	public PRHandler(String handlerName) {
		this.handlerName = handlerName;
	}
	
	public String getName(){
		return handlerName;
	}
	
	public abstract boolean authorize(PurchaseRequest request, String result);
	
	public PRHandler getNextHandler(){
		return nextHandler;
	}
	
	public void setNextHandler(PRHandler handler){
		nextHandler = handler;
	}

}
