package yakov.fain.lesson17;

import java.io.Serializable;

public class Employee implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String lName;
	private String fName;
	private int salary;
	
	public Employee(String lName, String fName, int salary) {
		this.setlName(lName);
		this.setfName(fName);
		this.setSalary(salary);
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public boolean increasePay(int percent) {
		System.out.println("Increasing salary by " + percent + "%. "  + getlName());
		return true;
	}
	
	public String toString(){
		return "First name - " + getfName() + "; Last name - " + getlName() + "; Salary - " + getSalary() + ".";
		
	}

}
