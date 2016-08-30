package Adapter;

public class DuckTestDrive {

	public static void main(String[] args) {
		
		MallardDuck duck = new MallardDuck();
		
		WildTurkey turkey = new WildTurkey();
		
		Duck turkeyAdapter = new TurkeyAdapter(turkey);
		Turkey duckAdapter = new DuckAdapter(duck);
		
		System.out.println("The turkey says: ");
		turkey.gobble();
		turkey.fly();
		
		System.out.println("\nThe duck says: ");
		testDuck(duck);
		
		System.out.println("\nThe turkeyAdapter says: ");
		testDuck(turkeyAdapter);
		
		System.out.println("\nThe duckAdapter says: ");
		testTurkey(duckAdapter);

	}

	private static void testDuck(Duck duck) {
		duck.quack();
		duck.fly();
	}
	
	private static void testTurkey(Turkey turkey){
		turkey.fly();
		turkey.gobble();
	}

}
