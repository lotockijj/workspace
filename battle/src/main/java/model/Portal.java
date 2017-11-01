package model;

import java.util.List;

public class Portal extends Droid {
	private List<Droid> droids;
	
	public Portal(String name, int health, int energy, int power, int price) {
		super(name, health, energy, power, price);
	}

	@Override
	public void performance(List<Droid> droids) {
		exchange();
	}

	private void exchange() {
		Droid weakestDroid = getWeakestDroid();
		Droid tempDroid = findThisDroid();
		change(tempDroid, weakestDroid);
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

	private Droid findThisDroid() {
		Droid searchDroid = null;
		for (int i = 0; i < droids.size(); i++) {
			if(droids.get(i) == this){
				searchDroid = droids.get(i);
				break;
			}
		}
		return searchDroid;
	}

	private void change(Droid tempDroid, Droid weakestDroid) {
		Droid swapDroid = tempDroid;
		tempDroid = weakestDroid;
		weakestDroid = swapDroid;
		System.out.println(tempDroid + " has changed place with " + weakestDroid);
	}

	public void setDroids(List<Droid> droids){
		this.droids = droids;
	}
}
