package duck2;

public class FightSimulator {

	public static void main(String[] args) {

		Character king = new King();
		king.display();
		king.performFight();
		king.setWeaponBehavior(new BowAndArrowBehavior());
		king.performFight();
		Character queen = new Queen();
		queen.display();
		queen.performFight();
		queen.setWeaponBehavior(new KnifeBehavior());
		queen.performFight();
		Character troll = new Troll();
		troll.display();
		troll.performFight();
		troll.setWeaponBehavior(new BowAndArrowBehavior());
		troll.performFight();
		Character knight = new Knight();
		knight.display();
		knight.performFight();
		knight.setWeaponBehavior(new BowAndArrowBehavior());
		knight.performFight();
		knight.setWeaponBehavior(new KnifeBehavior());
		knight.performFight();
		knight.setWeaponBehavior(new AxeBehavior());
		knight.performFight();
		System.out.println("\n ************* \n EVERY FIGHT AT ONCE! :) ");
		
		FightSimulator.doEverythingAtOnce(knight);
		FightSimulator.doEverythingAtOnce(troll);
		FightSimulator.doEverythingAtOnce(queen);
		FightSimulator.doEverythingAtOnce(king);

		System.out.println("\n ************* \n DO EVERYTHING WITH LOOP !!! :) :) :) ");
		FightSimulator.doEverythingWithLoop(knight);
		FightSimulator.doEverythingWithLoop(troll);
		FightSimulator.doEverythingWithLoop(queen);
		FightSimulator.doEverythingWithLoop(king);
//		double d = 67567.89;
//		long l = 56278;
//		int j = (int) d;
//		int i = new Integer(57);
//		System.out.println(d + " " + l + " " + j + " " + i) ;

	}
	
	public static void doEverythingAtOnce(Character c){
		c.display();
		c.setWeaponBehavior(new KnifeBehavior());
		c.performFight();
		
		c.display();
		c.setWeaponBehavior(new AxeBehavior());
		c.performFight();
		
		c.display();
		c.setWeaponBehavior(new SwordBehavior());
		c.performFight();
		
		c.display();
		c.setWeaponBehavior(new BowAndArrowBehavior());
		c.performFight();
	}
	
	public static void doEverythingWithLoop(Character c){
		WeaponBehavior[] weaponBehaviors = {new SwordBehavior(), new AxeBehavior(), new BowAndArrowBehavior(), new KnifeBehavior()};
		for(int i = 0; i < weaponBehaviors.length; i++){
			c.display();
			c.setWeaponBehavior(weaponBehaviors[i]);
			c.performFight();
		}
	}

}
