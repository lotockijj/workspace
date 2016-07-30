import java.util.Arrays;

public class TestEmployee{

	public static void main(String[] args) {

		Employee[] employee = new Employee[6];
		
		employee[0] = new Employee("Dana", 6, 6);
		employee[1] = new Employee("Jonh", 2, 2);
		employee[2] = new Employee("Karl", 6, 6);
		employee[3] = new Employee("Stive", 4, 4);
		employee[4] = new Employee("Sara", 4, 4);
		employee[5] = new Employee("Ella", 6, 6);
		
		Arrays.sort(employee, Employee.paymentOrName);
		
		for(Employee e : employee){
			System.out.println("Employee - " + e);
		} System.out.println("++++++++++++++++++++++++++++++++++");

		for(Employee e : employee){
			System.out.println("Employee - " + e);
		} System.out.println("++++++++++++++++++++++++++++++++++");

		System.out.println("First five employees from collection: ");
		for(int i = 0; i < 5; i++){
			System.out.println(employee[i]);
		}
		System.out.println("+++++++++++++++++++++++++++");

		System.out.println("Id last three employees from collection: ");
		for(int i = 0; i < 3; i++){
			System.out.println(employee[employee.length - 1 - i]);
		}

	}

}
