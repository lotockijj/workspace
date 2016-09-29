package duck2;

public class Queen extends Character{
	
	public Queen() {
		weaponBehavior = new BowAndArrowBehavior();
	}

	@Override
	public void display() {
		System.out.println("\nI'm queen. ");
	}

}
