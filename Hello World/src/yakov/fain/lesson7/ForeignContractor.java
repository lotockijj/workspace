package yakov.fain.lesson7;

public class ForeignContractor extends Persons {
	
	public ForeignContractor(String name){
		super(name);
	}
	public boolean increasePay(int percent) {
		System.out.println("I�m just a foreign worker. ");
		return true;
	}
}
