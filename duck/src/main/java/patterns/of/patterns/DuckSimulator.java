package patterns.of.patterns;

public class DuckSimulator {

	public static void main(String[] args) {

		DuckSimulator simulator = new DuckSimulator();
		simulator.simulate();
	}

	private void simulate() {
		Quackable mallardDuck = new MallardDuck();
		Quackable duckCall = new DuckCall();
		Quackable redHeadDuck = new RedHeadDuck();
		Quackable rubberDuck = new RubberDuck();
		Quackable gooseDuck = new GooseAdapter(new Goose());
		
		System.out.println("\nDuck simulator ");
		
		simulate(mallardDuck);
		simulate(duckCall);
		simulate(redHeadDuck);
		simulate(rubberDuck);
		simulate(gooseDuck);
	}

	private void simulate(Quackable duck) {
		duck.quack();
	}

}
