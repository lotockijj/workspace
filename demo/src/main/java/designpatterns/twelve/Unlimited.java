package designpatterns.twelve;

public class Unlimited implements Abonnement {

	@Override
	public String getDescription() {
		return "Unlimited";
	}

	@Override
	public int getCost() {
		return 520;
	}

}
