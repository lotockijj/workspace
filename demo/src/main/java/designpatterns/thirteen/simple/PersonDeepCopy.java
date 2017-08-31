package designpatterns.thirteen.simple;

public class PersonDeepCopy implements Cloneable{
	private String name;
	private Car car;

	public PersonDeepCopy(String name, String carName) {
		this.name = name;
		car = new Car(carName);
	}

	public String getName() {
		return name;
	}

	public Car getCar() {
		return car;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCar(Car car) {
		this.car = car;
	}
	
	public Object clone(){
		return new PersonDeepCopy(name, car.getName());
	}
}
