package designpatterns.chainofresponsibility;

public class RegionalDirector extends PRHandler {
	static double LIMIT = 100000;

	public RegionalDirector(String handlerName) {
		super(handlerName);
	}

	@Override
	public boolean authorize(PurchaseRequest request, String result) {
		double amount = request.getAmount();
		String resultRD = result + " Regional Director " + getName() +
				" has authorized the PR - " + request + "\n";
		if (amount <= LIMIT) {
			System.out.println(resultRD);
			return true;
		} else {
			return getNextHandler().authorize(request, resultRD);
		}

	}
}
