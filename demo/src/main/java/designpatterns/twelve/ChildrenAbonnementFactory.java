package designpatterns.twelve;

public class ChildrenAbonnementFactory implements AbonnementFactory {

	@Override
	public Abonnement createAbonnement(String abonnement) {
		if(abonnement.equalsIgnoreCase("1")){
			return new BaseForChildren12Times();
		}
		if(abonnement.equalsIgnoreCase("2")){
			return new BaseForChildrenUnlimited();
		}
		return null;
	}

}
