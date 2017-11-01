package state;

import java.util.Random;

public class Aim {
	private int flagLocation;
	private Random randomLocation;
	
	public Aim(){
		flagLocation = -1;
		randomLocation = new Random();
	}
	
	public int getFlagsLocation(int sumOfDroids) {
		if(flagLocation == -1){
			return randomLocation.nextInt(sumOfDroids);
		}
		return flagLocation;
	}
	
	public void setFlagsLocation(int flagLocation) {
		this.flagLocation = flagLocation;
	}
	
}
