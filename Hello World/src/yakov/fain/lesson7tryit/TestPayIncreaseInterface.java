package yakov.fain.lesson7tryit;

public class TestPayIncreaseInterface {
	
	public static void main(String[] args) {
		Payable workers[] = new Payable [3];
		workers[0] = new Employee("John");
		workers[1] = new Contractor("Mary");
		workers[2] = new Employee("Steve");
		for (Payable p: workers){
			((Payable)p).increasePay(30);
		}
		/*String s1 = "str"; 
		String s2 = "str"; 
		System.out.println("Result: " + s1 == s2); // !!!!!! */ 
	}
	
}