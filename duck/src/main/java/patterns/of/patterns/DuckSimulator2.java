package patterns.of.patterns;

public class DuckSimulator2 {

	public static void main(String[] args) {

		DuckSimulator2 simulate = new DuckSimulator2();
		simulate.simulate();
	}

	private void simulate() {
		Quackable mallardDuck = new QuackCounter(new MallardDuck());
		Quackable duckCall = new QuackCounter(new DuckCall());
		Quackable redHeadDuck = new QuackCounter(new RedHeadDuck());
		Quackable rubberDuck = new QuackCounter(new RubberDuck());
		Quackable gooseDuck = new GooseAdapter(new Goose());
		
		System.out.println("\nDuck simulator ");
		
		simulate(mallardDuck);
		simulate(duckCall);
		simulate(redHeadDuck);
		simulate(rubberDuck);
		simulate(gooseDuck);
		
		System.out.println("The ducks quacked " + QuackCounter.getQuacks() + " times.");
	}

	private void simulate(Quackable duck) {
		duck.quack();
	}

}
