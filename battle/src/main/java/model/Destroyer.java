package model;

import java.util.List;

public class Destroyer extends Droid {
	
	public Destroyer(String name, int health, int energy, int power, int price) {
		super(name, health, energy, power, price);
	}

	@Override
	public void performance(List<Droid> droids) {
		int chosenDroid = getAim().getFlagsLocation(droids.size());
		System.out.println("Destroyer has destroyed: " + droids.remove(chosenDroid));
	}
	
}
