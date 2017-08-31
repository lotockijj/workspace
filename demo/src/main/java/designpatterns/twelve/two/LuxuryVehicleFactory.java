package designpatterns.twelve.two;

public class LuxuryVehicleFactory extends VehicleFactory {
	
	@Override
	Car getCar() {
		return new LuxuryCar("L-C");
	}

	@Override
	SUV getSUV() {
		return new LuxurySUV("L-S");
	}

}
