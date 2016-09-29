package duck2;

public class King extends Character{

	public King(){
		weaponBehavior = new KnifeBehavior();
	}
	@Override
	public void display() {
		System.out.println("\nI'm king. ");
	}

}
