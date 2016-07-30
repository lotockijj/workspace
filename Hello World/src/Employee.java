import java.util.Comparator;

/* Create classes, which describe employees with hourly wage and fixed payment. Give your suggestions
about relations between classes. Implement method for calculating the average monthly salary. For
employees with hourly wage use next formula: “average monthly salary= 20.8*8* hourly rate”, for employees
with fixed payment – “average monthly salary= fixed monthly payment”. Write well commented code for
solving next problems
a) Sort the collection of employees in descending order by the average monthly salary. In the case of
equal salary – by the name. Write ID, name and monthly salary for all employees from collection.
b) Write information about first five employees from collection (problem a).
c) Write ID of three last employees from collection (problem b).
d) Write code for reading and writing collection of these objects from (into) file.
e) Write code for handling the incorrect format of incoming file.*/

public class Employee implements Comparable<Employee>{

	private String name; 
	private int hourlyWage;
	private int payment;

	public Employee(String name, int hourlyWage, int payment){
		this.setName(name);
		this.setHourlyWage(hourlyWage);
		this.setPayment(payment);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getHourlyWage() {
		return hourlyWage;
	}

	public void setHourlyWage(int hourlyWage) {
		this.hourlyWage = hourlyWage;
	}

	public double getPayment() {
		return payment;
	}

	public void setPayment(int payment) {
		this.payment = payment;
	}
	
	public int calculeteAverageMonthlySalary(){
		int AverageMonthlySalary = (int) (20.8*8*getHourlyWage()*getPayment());
		System.out.println("AverageMonthlySalary - " + AverageMonthlySalary);
		return AverageMonthlySalary; 
	}

	public String toString(){
		return this.name + " " + this.hourlyWage + " " + this.payment; 
	}

	@Override
	public int compareTo(Employee o) {
		return this.getName().compareTo(o.getName());
	}
	
	public static Comparator<Employee> paymentOrName = new Comparator<Employee>(){
		@Override
		public int compare(Employee o1, Employee o2) {
			System.out.println(o1.toString() + " <> " + o2.toString());
			int flag = (int) (o1.calculeteAverageMonthlySalary() 
					- o2.calculeteAverageMonthlySalary());
			System.out.println(flag);
			if(flag == 0){
				flag = o2.getName().compareTo(o2.getName());
			}
			return flag;
		}
	};
	
}
