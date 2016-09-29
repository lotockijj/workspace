package duck2;

public class Knight extends Character{
	
	public Knight(){
		weaponBehavior = new SwordBehavior();
	}

	@Override
	public void display() {
		System.out.println("\nI'm noble knight...");
	}

}
