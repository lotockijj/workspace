package designpatterns.twelve;

public class BaseForChildrenUnlimited implements Abonnement {

	@Override
	public String getDescription() {
		return "The whole day unlimited for children";
	}

	@Override
	public int getCost() {
		return 250;
	}

}
