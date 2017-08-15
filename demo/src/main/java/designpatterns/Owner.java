package designpatterns;

public class Owner implements SalaryCalculator{
	private String name;
	private int dayOfWorks;
	private int numberOfHours;
	
	public Owner(String name, int dayOfWorks, int numberOfHours) {
		this.name = name;
		this.dayOfWorks = dayOfWorks;
		this.numberOfHours = numberOfHours;
	}
	
	@Override
	public double getSalary() {
		return dayOfWorks*numberOfHours;
	}

	@Override
	public String toString() {
		return "Owner [name=" + name + ", dayOfWorks=" + dayOfWorks + ", numberOfHours=" + numberOfHours + "]";
	}

}
