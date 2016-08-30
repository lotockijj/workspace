package StateOfThings;

import java.util.Random;

public class HasQuarterState implements State {
	
	Random randomWinner = new Random(System.currentTimeMillis());
	transient GumballMachine2 gumballMachine2;
	
	public HasQuarterState(GumballMachine2 gumballMachine2){
		this.gumballMachine2 = gumballMachine2;
	}

	public void insertQuarter() {
		System.out.println("You can’t insert another quarter");
	}

	public void ejectQuarter() {
		System.out.println("Quarter returned");
		gumballMachine2.setState(gumballMachine2.noQuarterState);
	}

	public void turnCrank() {
		System.out.println("You turned...");
		int winner = randomWinner.nextInt(10);
		if ((winner == 0) && (gumballMachine2.getCount() > 1)) {
			gumballMachine2.setState(gumballMachine2.getWinnerState());
		} else {
			gumballMachine2.setState(gumballMachine2.getSoldState());
		}
	}

	public void dispense() {
		System.out.println("No gumball dispensed");
	}

}
