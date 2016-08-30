package StateOfThings;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class GumballMachine2 extends UnicastRemoteObject implements GumballMachineRemote{

	State soldOutState;
	State noQuarterState;
	State hasQuarterState;
	State soldState;
	State state = soldOutState;
	String location;
	State winnerState; 
	int count = 0;

	public GumballMachine2(String location, int numberGumballs) throws RemoteException{
		soldOutState = new SoldOutState(this);
		noQuarterState = new NoQuarterState(this);
		hasQuarterState = new HasQuarterState(this);
		soldState = new SoldState(this);
		winnerState = new WinnerState(this);
		this.count = numberGumballs;
		this.location = location;
		if(count > 0){
			state = noQuarterState;
		}
	}

	public void insertQuarter(){
		state.insertQuarter();
	}

	public void ejectQuarter(){
		state.ejectQuarter();
	}

	public void turnCrank(){
		state.turnCrank();
		state.dispense();
	}

	void setState(State state){
		this.state = state;
	}

	void releaseBall(){
		System.out.println("A gumball comes rolling out the slot...");
		if(count != 0){
			count = count - 1; 
		}
	}
	// More methods here including getters for each State...
	//	This includes methods like getNoQuarterState() for getting each
	//	state object, and getCount() for getting the gumball count.

	public State getSoldOutState() {
		return soldOutState;
	}

	public State getNoQuarterState() {
		return noQuarterState;
	}

	public State getHasQuarterState() {
		return hasQuarterState;
	}

	public State getSoldState() {
		return soldState;
	}

	public State getState() {
		return state;
	}

	public int getCount() {
		return count;
	}

	public State getWinnerState() {
		return winnerState;
	}

	public String getLocation() {
		return location;
	}

	public void setSoldOutState(State soldOutState) {
		this.soldOutState = soldOutState;
	}

	public void setNoQuarterState(State noQuarterState) {
		this.noQuarterState = noQuarterState;
	}

	public void setHasQuarterState(State hasQuarterState) {
		this.hasQuarterState = hasQuarterState;
	}

	public void setSoldState(State soldState) {
		this.soldState = soldState;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void setWinnerState(State winnerState) {
		this.winnerState = winnerState;
	}

	public void  refill(int count){
		this.count = count;
		state = noQuarterState;
	}

	public String toString(){
		StringBuilder str = new StringBuilder();
		str.append("\nMighty Gumball, Inc.\n");
		str.append("Java-enabled Standing Gumball Model #2004\n");
		str.append("Inventory: " + count + " gumballs");
		return str.toString();
	}
}
