//Consider classes Customer and Rental, which represent customer and information about rent.
//Move method amountFor(…)into class Rental. Give explanation of this moving. Propose the solution for
//improving code quality.
class Customer {
	private String name;
	// Other fields, constructors, get, set, etc.
	//
	public Customer(String name) {
		this.name=name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	
	// Other methods.
}
class Rental {
	private int kind;
	private int days;
	// Other fields, constructors, get, set, etc.
	//
	public Rental(int kind, int days) {
		this.kind=kind;
		this.days=days;
	}
	public int getKind() {
		return kind;
	}
	public void setKind(int kind) {
		this.kind=kind;
	}
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days=days;
	}
	public double getBasePrice() {
		// Calculation of Price.
		// . . .
		return 0;
	}
	private double amountFor(Rental rental) { //Because Customer not define rent... 
		double result;
		// Another code.
		result = rental.getDays()*rental.getBasePrice();
		if (rental.getKind()==1) {
			result = result*1.5;
		}
		if (rental.getKind()==2) {
			result = result*2;
		}
		if (rental.getKind()==3) {
			result = result*2.5;
		}
		if (rental.getDays()>7) {
			result = result*3;
		}
		// Other calculation.
		return result;
	}// Other methods.
}