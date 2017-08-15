package designpatterns;

public class Worker implements SalaryCalculator{
	private String name;
	private int dayOfWork;
	private int hoursOfWork;
	
	public Worker(String name, int dayOfWork, int hoursOfWork) {
		this.name = name;
		this.dayOfWork = dayOfWork;
		this.hoursOfWork = hoursOfWork;
	}
	
	@Override
	public double getSalary() {
		return dayOfWork*(0.5*hoursOfWork);
	}

	@Override
	public String toString() {
		return "Worker [name=" + name + ", dayOfWork=" + dayOfWork + ", hoursOfWork=" + hoursOfWork + "]";
	}
	
	

}
