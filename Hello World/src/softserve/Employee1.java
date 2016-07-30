package softserve;

import java.util.Comparator;

public abstract class Employee1 {
	String firstName;
	String secondName;
	int id;

	public Employee1(String firstName, String secondName,int id){
		this.firstName = firstName;
		this.secondName = secondName;
		this.id = id;
	}

	public abstract double getMonthlySalary(); 


	public void printEmployee(){
		System.out.println(firstName+" "+secondName+" "+id);
	}

	public String toString(){
		return firstName + " " + secondName + " " + id + "\n";
		
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public static Comparator<Employee1> idOrNameComparator = new Comparator<Employee1>(){
		public int compare(Employee1 o1, Employee1 o2) {
			int flag = (int)(o1.getMonthlySalary() - o2.getMonthlySalary());
			if(flag == 0) o1.getSecondName().compareTo(o2.getSecondName());
			return flag;
		}
	};

}