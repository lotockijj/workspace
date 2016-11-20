package softserve3;

public class Department {
	private String name;
	private String id;
	private Double annualCost;
	
	public Department(String name, String id, Double annualCost) {
		this.name = name;
		this.id = id;
		this.annualCost = annualCost;
	}
	public String getName() {
		return name;
	}
	public String getId() {
		return id;
	}
	public Double getAnnualCost() {
		return annualCost;
	}
	// other method; 
}
