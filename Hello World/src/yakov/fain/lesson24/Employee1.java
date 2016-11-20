package yakov.fain.lesson24;

public class Employee1 extends Person {
	String lastName;
	String firstName;
	
	@Override
	public void raiseSalary() {
		System.out.println("Raising salary for Employee... ");
	}
	
	public void changeAddress(String newAddress){
		System.out.println("The new address is " + newAddress);
	}

}
