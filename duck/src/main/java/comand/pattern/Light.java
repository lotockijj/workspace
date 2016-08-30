package comand.pattern;

public class Light {
	
	String name;
	
	public Light(String name) {
		this.name = name; 
	}

	public void on(){
		System.out.println("Light is on.");
	}
	
	public void off(){
		System.out.println("Light is off.");
	}

}
