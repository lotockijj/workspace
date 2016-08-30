package StateOfThings;

import java.rmi.RemoteException;

public class GumballMachineTestDrive3 {

	public static void main(String[] args) throws RemoteException {
		
		int count = 0;
		
		if(args.length < 2){
			System.out.println("GumballMachine <name> <inventory>");
			System.exit(1);
		}
		
		count = Integer.parseInt(args[1]);
		GumballMachine2 gumballMachine2 = new GumballMachine2(args[0], count);
		GumballMonitor monitor = new GumballMonitor(gumballMachine2);
		monitor.report();

	}

}
