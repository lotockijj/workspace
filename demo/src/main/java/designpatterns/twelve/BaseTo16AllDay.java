package designpatterns.twelve;

public class BaseTo16AllDay implements Abonnement {

	@Override
	public String getDescription() {
		return "To 16 o'clock unlimited.";
	}

	@Override
	public int getCost() {
		return 490;
	}

}
