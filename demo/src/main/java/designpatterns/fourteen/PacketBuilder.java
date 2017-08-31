package designpatterns.fourteen;

public class PacketBuilder implements Builder {
	private String aComponent;
	private String bComponent;
	
	@Override
	public void createComponentA() {
		aComponent  = "A";
	}

	@Override
	public void createComponentB() {
		bComponent  = "B";
	}

	@Override
	public Object getObject() {
		return aComponent + bComponent + " packet";
	}

}
