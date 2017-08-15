package designpatterns.second.validator;

public class USAddress implements AddressValidator {

	@Override
	public boolean validate(Address address) {
		if(address.getCountry() == "USA"){
			return true;
		}
		return false;
	}


}
