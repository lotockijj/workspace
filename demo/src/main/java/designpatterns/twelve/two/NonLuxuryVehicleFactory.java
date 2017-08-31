package designpatterns.twelve.two;

public class NonLuxuryVehicleFactory extends VehicleFactory {
	
	@Override
	Car getCar() {
		return new NonLuxuryCar("NL-C");
	}

	@Override
	SUV getSUV() {
		return new NonLuxurySUV("NL-S");
	}

}
