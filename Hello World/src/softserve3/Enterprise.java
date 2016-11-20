package softserve3;

public class Enterprise {

	// three private fields are here

	private String name;
	private String id;
	private Double annualCost;

	public String getName(){
		return name;

	}

	public String getId(){
		return id; 

	}

	public Double getAnnualCost(){
		return annualCost; 

	}

	// other classes should extend EnterpriseResource, call superCons
}
