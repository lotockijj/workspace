package designpatterns.second.validator;

public class Client {
	
	public static void main(String[] args) {
		Address addressUSA = new Address("USA", "Colorado", "Pitsburg");
		AddressValidator usaValidator = new USAddress();
		System.out.println(usaValidator.validate(addressUSA));
		usaValidator = new CAAddress();
		System.out.println(usaValidator.validate(addressUSA));
		Address addressCA = new Address("CA", "Toronto", "Ottawa");
		System.out.println(usaValidator.validate(addressCA));
	}
}
