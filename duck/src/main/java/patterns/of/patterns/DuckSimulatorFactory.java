package patterns.of.patterns;

public class DuckSimulatorFactory {

	public static void main(String[] args) {
		DuckSimulatorFactory simulator = new DuckSimulatorFactory();
		AbstractDuckFactory duckFactory = new CountingDuckFactory();
		
		simulator.simulate(duckFactory);
	}

	private void simulate(AbstractDuckFactory duckFactory) {
		Quackable mallardDuck = duckFactory.createMallardDuck();
		Quackable redHeadDuck = duckFactory.createRedHeadDuck();
		Quackable rubberDuck = duckFactory.createRubberDuck();
		Quackable duckCall = duckFactory.createDuckCall();
		Quackable gooseDuck = new GooseAdapter(new Goose());
		
		System.out.println("\nDuck Simulator: With Abstract Factory");
		
		simulate(mallardDuck);
		simulate(redHeadDuck);
		simulate(rubberDuck);
		simulate(duckCall);
		simulate(gooseDuck);
		
		System.out.println("The ducks quacked " + QuackCounter.getQuacks() + " times.");
	}
	
	private void simulate(Quackable duck){
		duck.quack();
	}
}
