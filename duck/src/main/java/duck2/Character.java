package duck2;

public abstract class Character {
	
	WeaponBehavior weaponBehavior;
	
	public Character() {
	}

	public void setWeaponBehavior(WeaponBehavior fb){
		this.weaponBehavior = fb;
	}
	
	 public abstract void display();
	
	public void performFight(){
		weaponBehavior.useWeapon();
	}
	
}
