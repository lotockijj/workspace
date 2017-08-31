package designpatterns.twelve.two;

public class VehicleFactoryUsingPrototype extends VehicleFactory{
	private Car car;
	private SUV suv;
	
	public VehicleFactoryUsingPrototype(Car car, SUV suv) {
		this.car = car;
		this.suv = suv;
	}

	@Override
	Car getCar() {
		return (Car) car.clone();
	}

	@Override
	SUV getSUV() {
		return (SUV) suv.clone();
	}

}
