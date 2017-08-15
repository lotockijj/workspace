package designpatterns;

public class Client {
	
	public static void main(String[] args) {
		SalaryCalculator salary = new Worker("plumber", 5, 8);
		Person person = new Person("John", salary);
		System.out.println(person);

		salary = new Owner("GreenGrocer", 5, 8);
		person = new Person("Mary", salary);
		System.out.println(person);
	}
}
