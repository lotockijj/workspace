package designpatterns.chainofresponsibility;

public class VicePresident extends PRHandler {
	static double LIMIT = 200000;

	public VicePresident(String handlerName) {
		super(handlerName);
	}

	@Override
	public boolean authorize(PurchaseRequest request, String result) {
		double amount = request.getAmount();
		String resultVP = result + " V.P. " + getName() +
				" has authorized the PR - " + request + "\n";
		if (amount <= LIMIT) {
			System.out.println(resultVP);
			return true;
		} else {
			//forward the request to the next handler
			return getNextHandler().authorize(request, resultVP);
		}
	}

}
