package yakov.fain.lesson7tryit;

public class Employee implements Payable{
	
	private String name;
	
	public Employee(String name){
		this.name=name;
	}
	
	public boolean increasePay(int percent) {
		System.out.println("Increasing salary by " + percent
				+ "%: " + name);
		return true;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
