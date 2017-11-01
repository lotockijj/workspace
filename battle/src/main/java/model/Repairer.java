package model;

import java.util.List;

public class Repairer extends Droid {
	private List<Droid> droids; 
	
	public Repairer(String name, int health, int energy, int power, int price) {
		super(name, health, energy, power, price);
	}

	@Override
	public void performance(List<Droid> droids) {
		Droid weakestDroid = getWeakestDroid();
		repair(weakestDroid);
	}

	private Droid getWeakestDroid() {
		Droid droid = droids.get(0);
		for (int i = 1; i < droids.size(); i++) {
			if(droid.getHealth() > droids.get(i).getHealth()){
				droid = droids.get(i);
			}
		}
		return droid;
	}
	
	private void repair(Droid weakestDroid) {
		int health = weakestDroid.getHealth();
		weakestDroid.setHealth(health + getEnergy());
		System.out.println(this.getName() + " repaired " + weakestDroid.getName());
	}
	
	public void setDroids(List<Droid> droids) {
		this.droids = droids;
	}
}
