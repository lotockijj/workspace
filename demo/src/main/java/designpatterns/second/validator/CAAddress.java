package designpatterns.second.validator;

public class CAAddress implements AddressValidator {

	@Override
	public boolean validate(Address address) {
		if(address.getCountry() == "CA"){
			return true;
		}
		return false;
	}

}
