package StateOfThings;

import java.rmi.Naming;

public class GumballMachineTestDriveRemote {

	public static void main(String[] args) {

		GumballMachine2 gumballMachine2 = null;
		int count;
		if(args.length < 2){
			System.out.println("GumballMachine <name> <inventory>");
			System.exit(1);
		}
		
		try{
			count = Integer.parseInt(args[1]);
			gumballMachine2 = new GumballMachine2(args[0], count);
			Naming.rebind("//" + args[0] + "/gumballmachine", gumballMachine2);
		} catch (Exception e){
			e.printStackTrace();
		}

	}

}
