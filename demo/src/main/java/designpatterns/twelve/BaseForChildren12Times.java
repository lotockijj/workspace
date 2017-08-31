package designpatterns.twelve;

public class BaseForChildren12Times implements Abonnement {

	@Override
	public String getDescription() {
		return "Base for childer 12 times each month.";
	}

	@Override
	public int getCost() {
		return 200;
	}

}
