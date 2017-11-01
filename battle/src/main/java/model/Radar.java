package model;

import java.util.List;

public class Radar extends Droid{
	private List<Droid> droids; 
	
	public Radar(String name, int health, int energy, int power, int price) {
		super(name, health, energy, power, price);
	}

	@Override
	public void performance(List<Droid> droids) {
		int flagLocation = -1;
		for (int i = 0; i < droids.size(); i++) {
			if(droids.get(i).getFlag() == true){
				flagLocation = i;
			}
		}
		notifyDroids(flagLocation);
	}

	private void notifyDroids(int flagLocation) {
		System.out.println("Team is notified that flag is in the position: " + flagLocation);
		for (int i = 0; i < droids.size(); i++) {
			droids.get(i).getAim().setFlagsLocation(flagLocation);
		}
	}

	public void setDroids(List<Droid> droids) {
		this.droids = droids;
	}
	
}
