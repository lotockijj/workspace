package duck2;

public class Troll extends Character{
	
	public Troll(){
		weaponBehavior = new AxeBehavior();
	}

	@Override
	public void display() {
		System.out.println("\nI'm troll.");
	}
	
}
