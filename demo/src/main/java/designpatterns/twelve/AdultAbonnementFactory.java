package designpatterns.twelve;

public class AdultAbonnementFactory implements AbonnementFactory {

	@Override
	public Abonnement createAbonnement(String abonnement) {
		if(abonnement.equalsIgnoreCase("1")){
			return new BaseTo16Times12();
		} 
		if(abonnement.equalsIgnoreCase("2")){
			return new BaseTo16AllDay();
		}
		if(abonnement.equalsIgnoreCase("3")){
			return new BaseAllDay12Times();
		}
		if(abonnement.equals("4")){
			return new Unlimited();
		}
		return null;
	}

}
