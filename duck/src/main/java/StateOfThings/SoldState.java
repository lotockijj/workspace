package StateOfThings;

public class SoldState implements State {
	
	transient GumballMachine2 gumballMachine2;
	
	public SoldState(GumballMachine2 gumballMachine2){
		this.gumballMachine2 = gumballMachine2;
	}

	public void insertQuarter() {
		System.out.println("Please wait, we’re already giving you a gumball");
	}

	public void ejectQuarter() {
		System.out.println("Sorry, you already turned the crank");
	}

	public void turnCrank() {
		System.out.println("Turning twice doesn’t get you another gumball!");
	}

	public void dispense() {
		gumballMachine2.releaseBall();
		if(gumballMachine2.getCount() > 0){
			gumballMachine2.setState(gumballMachine2.getNoQuarterState());
		} else { 
			System.out.println("Oops, out of gumballs!");
			gumballMachine2.setState(gumballMachine2.getSoldOutState());
		}
	}

}
