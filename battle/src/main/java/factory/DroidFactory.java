package factory;

import model.Destroyer;
import model.Droid;
import model.Fighter;
import model.Portal;
import model.Repairer;

public class DroidFactory {
	private static int id = 1;
	
	public static Droid getFighter(){
		String name = Integer.toString(id++);
		name = "Fighter " + name;
		Droid droid = new Fighter(name, 4, 10, 2, 1);
		return droid;
	}
	
	public static Droid getDestroyer(){
		String name = Integer.toString(id++);
		name = "Destroyer " + name;
		Droid droid = new Destroyer(name, 4, 10, 2, 1);
		return droid;
	}
	
	public static Droid getPortal(){
		String name = Integer.toString(id++);
		name = "Portal " + name;
		Droid droid = new Portal(name, 10, 10, 10, 10);
		return droid;
	}
	
	public static Droid getRadar(){
		String name = Integer.toString(id++);
		name = "Radar " + name;
		Droid droid = new Portal(name, 4, 10, 2, 5);
		return droid;
	}
	
	public static Droid getRepairer(){
		String name = Integer.toString(id++);
		name = "Repairer " + name;
		Droid droid = new Repairer(name, 10, 10, 10, 10);
		return droid;		
	}
}
