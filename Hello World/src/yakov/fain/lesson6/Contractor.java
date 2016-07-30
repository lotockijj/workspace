package yakov.fain.lesson6;

public class Contractor extends Person implements Payable {

	public Contractor(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public boolean increasePay(int percent) {
		if(percent < INCREASE_CAP){
			System.out.println("Increasing salary by " + percent + "%. "  + getName());
		} else if(percent > INCREASE_CAP){
			System.out.println("You can’t increase a contractor’s "
					+ "rate by more than 20 percent.");
		}
		return true;
	}

}
