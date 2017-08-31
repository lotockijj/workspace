package designpatterns.twelve.two;

public class LuxurySUV implements SUV{
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LuxurySUV(String name) {
		this.name = name;
	}

	@Override
	public String getSUVName(String name) {
		return name;
	}

	@Override
	public String getSUVFeatures() {
		return "Conditioning, JPS, bed.";
	}
	
	@Override
	public Object clone(){
		return new LuxurySUV(name);
	}

}
