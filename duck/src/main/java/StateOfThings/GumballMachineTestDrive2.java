package StateOfThings;

import java.rmi.RemoteException;

public class GumballMachineTestDrive2 {

	public static void main(String[] args) throws RemoteException {

		GumballMachine2 gumballMachine2 = new GumballMachine2("Lviv", 5);
		
		System.out.println(gumballMachine2);
		
		gumballMachine2.insertQuarter();
		gumballMachine2.turnCrank();
		
		System.out.println(gumballMachine2);
		
		gumballMachine2.insertQuarter();
		gumballMachine2.turnCrank();
		gumballMachine2.insertQuarter();
		gumballMachine2.turnCrank();
		System.out.println(gumballMachine2);
		GumballMonitor monitor = new GumballMonitor(gumballMachine2);
		System.out.println("\nMONITOR: \n");
		monitor.report();

	}

}
