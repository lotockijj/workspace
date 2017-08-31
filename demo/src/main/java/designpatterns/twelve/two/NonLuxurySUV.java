package designpatterns.twelve.two;

public class NonLuxurySUV implements SUV {
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public NonLuxurySUV(String name) {
		this.name = name;
	}

	@Override
	public String getSUVName(String name) {
		return name;
	}

	@Override
	public String getSUVFeatures() {
		return "Empty SUV";
	}
	
	@Override
	public Object clone(){
		return new NonLuxurySUV(name);
	}

}
