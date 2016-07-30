package softserve;

public class EmployeeHourlyWage extends Employee1 {
	Double hourlyWage;

	public EmployeeHourlyWage(String firstName, String secondName, int id, double hourlyRate) {
		super(firstName, secondName, id);
		hourlyWage = 20.8*8*hourlyRate;
	}
	
	public double getWage(){
		return hourlyWage; 
	}
	

	public void setWage(double rate) {
		hourlyWage = 20.8*8*rate;
	}
	
	@Override
	public double getMonthlySalary() {
		return hourlyWage * 20.8 * 8;
	}

}