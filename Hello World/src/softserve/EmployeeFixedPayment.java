package softserve;

public class EmployeeFixedPayment extends Employee1 {
	double fixedPayment;

	public EmployeeFixedPayment(String firstName, String secondName, int id,
			double salary) {
		super(firstName, secondName, id);
		fixedPayment = salary;
	}

	public double getSalary() {
		return fixedPayment;
	}

	public void setSalary(double salary) {
		fixedPayment = salary;
	}

	@Override
	public double getMonthlySalary() {
		return fixedPayment;
	}
	
}