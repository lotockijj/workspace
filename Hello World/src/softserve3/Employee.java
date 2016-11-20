package softserve3;

//Create superclass for these two classes and change existing code for avoiding the duplication. Please propose the other solutions for improving quality of the code.
public class Employee {
	private String name;
	private String id;
	private String annualCost;
	
	public Employee(String name, String id) {
		this.name = name;
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public String getId() {
		return id;
	}
	public String getAnnualCost() {
		//calculate the annual report... 
		return annualCost;
	}
	// other method; 

}
