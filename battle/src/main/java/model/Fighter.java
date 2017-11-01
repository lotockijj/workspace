package model;

import java.util.List;

public class Fighter extends Droid {

	public Fighter(String name, int health, int energy, int power, int price) {
		super(name, health, energy, power, price);
	}

	@Override
	public void performance(List<Droid> droids) {
		int chosenDroid = getPosition(droids);
		droids.get(chosenDroid).getShot(getPower());
		System.out.println(getName() + " -> " + droids.get(chosenDroid).getName() + ": health(" + 
				droids.get(chosenDroid).getHealth() + ")");
		deleteDroidWithHealthBelowZero(droids, chosenDroid);
	}

	private int getPosition(List<Droid> droids) {
		return getAim().getFlagsLocation(droids.size());
	}

}
