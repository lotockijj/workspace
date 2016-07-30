package CompareComparator;

import java.util.Arrays;
import java.util.Comparator;

public class Employee implements Comparable<Employee>{
	 
    private int id;
    private String name;
    private int age;
    private long salary;
 
    public int getId() {
        return id;
    }
 
    public String getName() {
        return name;
    }
 
    public int getAge() {
        return age;
    }
 
    public long getSalary() {
        return salary;
    }
 
    public Employee(int id, String name, int age, int salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
 
    @Override
    // Override method toString():
    public String toString() {
        return "[id=" + this.id + ", name=" + this.name + 
               ", age=" + this.age + ", salary=" + this.salary + "]";
    }

	@Override
	public int compareTo(Employee o) {
		return this.id - o.id;
	}
	
	public static Comparator<Employee> salaryComparator = new Comparator<Employee>(){
		@Override
		public int compare(Employee o1, Employee o2) {
			return (int) (o1.getSalary() - o2.getSalary());
		}
	};
	
	public static Comparator<Employee> ageComparator = new Comparator<Employee>() {
		@Override
		public int compare(Employee o1, Employee o2) {
			return (int)(o1.getAge() - o2.getAge());
		}
	};
	
	public static Comparator<Employee> nameComparator = new Comparator<Employee>() {
		@Override
		public int compare(Employee o1, Employee o2) {
			return o1.getName().compareTo(o2.getName());
		}
	};
	
	public static Comparator<Employee> idOrNameComparator = new Comparator<Employee>(){
		public int compare(Employee o1, Employee o2) {
			int flag = o1.getId() - o2.getId();
			if(flag == 0) o1.getName().compareTo(o2.getName());
			return flag;
		}
	};
	
	public static void main(String[] args){
		
		Employee[] empArr = new Employee[6];
		
		empArr[0] = new Employee(10, "Andrew", 21, 10000);
		empArr[1] = new Employee(20, "Dmitriy", 49, 20000);
		empArr[2] = new Employee(5, "Viktor", 45, 5000);
		empArr[3] = new Employee(1, "Alex", 42, 50000);
		empArr[4] = new Employee(5, "Adrian", 40, 40000);
		empArr[5] = new Employee(5, "Sessil", 44, 30000); 
		
		Arrays.sort(empArr);
		showEmployeeArray(empArr, "id");
		
		Arrays.sort(empArr, Employee.salaryComparator); 
		showEmployeeArray(empArr, "salary");
		
		Arrays.sort(empArr, Employee.nameComparator);
		showEmployeeArray(empArr, "name");
		
		Arrays.sort(empArr, Employee.ageComparator);
		showEmployeeArray(empArr, "age");
		
		Arrays.sort(empArr, Employee.idOrNameComparator);
		showEmployeeArray(empArr, "id and name");

	}

	private static void showEmployeeArray(Employee[] empArr, String s) {
		System.out.println("Sort  Employee by " +  s + ":\n"
				+ Arrays.toString(empArr));
		System.out.println("___________________________");
	}
}