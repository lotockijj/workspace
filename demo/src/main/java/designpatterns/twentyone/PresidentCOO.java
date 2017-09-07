package designpatterns.twentyone;

public class PresidentCOO extends PRHandler {
	static double LIMIT = 400000;

	public PresidentCOO(String handlerName) {
		super(handlerName);
	}

	@Override
	public boolean authorize(PurchaseRequest request, String result) {
		double amount = request.getAmount();
		String resultPCOO = result + " President & COO " + getName() +
				" has authorized the PR - " + request;
		if (amount <= LIMIT) {
			System.out.println(resultPCOO);
			return true;
		} else {
			System.out.println("PR - " + request +
					" couldn't be authorized.\n " +
					"Executive Board needs to be " +
					"consulted for approval \n" +
					"reason: Amount too large");
			return false;
		}

	}
}
