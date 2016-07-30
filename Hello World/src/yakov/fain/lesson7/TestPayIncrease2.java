package yakov.fain.lesson7;

public class TestPayIncrease2 {
	
	public static void main(String[] args) {
		
		Persons workers[] = new Persons[4];
		
		workers[0] = new Employee("John");
		workers[1] = new Contractor("Mary");
		workers[2] = new Employee("Steve");
		workers[3] = new ForeignContractor("Roman"); 
		for (Persons p: workers){
			p.promote(30);
		}
	}
}