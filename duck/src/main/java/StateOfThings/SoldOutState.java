package StateOfThings;

public class SoldOutState implements State {

	transient GumballMachine2 gumballMachine2;

	public SoldOutState(GumballMachine2 gumballMachine2) {
		this.gumballMachine2 = gumballMachine2;
	}

	public void insertQuarter() {
		System.out.println("You can’t insert a quarter, the machine is sold out");
	}

	public void ejectQuarter() {
		System.out.println("You can’t eject, you haven’t inserted a quarter yet");
	}

	public void turnCrank() {
		System.out.println("You turned, but there are no gumballs ");
	}

	public void dispense() {
		System.out.println("No gumball dispensed!!! :) ");
	}

}
