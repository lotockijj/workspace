package designpatterns.twelve.two;

public class NonLuxuryCar implements Car {
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public NonLuxuryCar(String name) {
		this.name = name;
	}

	@Override
	public String getCarName() {
		return name;
	}

	@Override
	public String getCarFeatures() {
		return "Empty set";
	}
	
	@Override
	public Object clone(){
		return new NonLuxuryCar(name);
	}

}
