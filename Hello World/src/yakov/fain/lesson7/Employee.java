package yakov.fain.lesson7;

public class Employee extends Persons{
	
	public Employee(String name){
		super(name);
	}
	
	public boolean increasePay(int percent) {
		System.out.println("Increasing salary by "
				+ percent + "%. " + getName());
		return true;
	}
}