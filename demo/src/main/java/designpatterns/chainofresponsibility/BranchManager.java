package designpatterns.chainofresponsibility;

public class BranchManager extends PRHandler {
	static double LIMIT = 25000;
	
	public BranchManager(String handlerName) {
		super(handlerName);
	}
	

	@Override
	public boolean authorize(PurchaseRequest request, String result) {
		double amount = request.getAmount();
		String resultM = " Branch Manager " + getName() +
				" has authorized the PR - " + request + "\n";
		if(amount <= LIMIT){
			System.out.println(resultM);
					return true;
		} else {
			return getNextHandler().authorize(request, resultM);
		}
	}
	

}
