package designpatterns.twelve;

public class BaseAllDay12Times implements Abonnement {

	@Override
	public String getDescription() {
		return "The whole day twelve times each month.";
	}

	@Override
	public int getCost() {
		return 450;
	}


}