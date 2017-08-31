package designpatterns.twelve.two;

public class LuxuryCar implements Car, Cloneable{
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getCarName() {
		return name;
	}
	
	public LuxuryCar(String name) {
		this.name = name;
	}


	@Override
	public String getCarFeatures() {
		return "Conditioning, computer, TV, JPS.";
	}

	//	@Override
	//	public Object clone(){
	//		return new LuxuryCar(name);
	//	}

	@Override
	public Object clone(){
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}

}
