package designpatterns.fourteen;

public class BoxBuilder implements Builder {

	private String aComponent;
	private String bComponent;
	
	@Override
	public void createComponentA() {
		aComponent  = "C";
	}

	@Override
	public void createComponentB() {
		bComponent  = "D";
	}

	@Override
	public Object getObject() {
		return aComponent + bComponent + " box";
	}
}
