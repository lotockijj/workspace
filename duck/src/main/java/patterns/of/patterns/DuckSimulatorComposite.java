package patterns.of.patterns;

public class DuckSimulatorComposite {

	public static void main(String[] args) {


		DuckSimulatorComposite simulator = new DuckSimulatorComposite();
		AbstractDuckFactory duckFactory = new CountingDuckFactory();
		
		simulator.simulate(duckFactory);

	}

	private void simulate(AbstractDuckFactory duckFactory) {
		Quackable redHeadDuck = duckFactory.createRedHeadDuck();
		Quackable duckCall = duckFactory.createDuckCall();
		Quackable rubberDuck = duckFactory.createRubberDuck();
		Quackable gooseDuck = new GooseAdapter(new Goose());
		
		Flock flockOfDucks = new Flock();
		
		flockOfDucks.add(redHeadDuck);
		flockOfDucks.add(duckCall);
		flockOfDucks.add(rubberDuck);
		flockOfDucks.add(gooseDuck);
		
		Flock flockOfMallardDucks = new Flock();
		
		Quackable mallardDucksOne = duckFactory.createMallardDuck();
		Quackable mallardDucksTwo = duckFactory.createMallardDuck();
		Quackable mallardDucksThree = duckFactory.createMallardDuck();
		Quackable mallardDucksFour = duckFactory.createMallardDuck();
		
		flockOfMallardDucks.add(mallardDucksOne);
		flockOfMallardDucks.add(mallardDucksTwo);
		flockOfMallardDucks.add(mallardDucksThree);
		flockOfMallardDucks.add(mallardDucksFour);
		
		flockOfDucks.add(flockOfMallardDucks);
		
		System.out.println("\nDuck Simulator: Whole Flock Simulation");
		
		simulate(flockOfDucks);
		
		System.out.println("\nDuck Simulator: Mallard Flock Simulation");
		
		simulate(flockOfMallardDucks);
		
		System.out.println("\nThe ducks quacked " + QuackCounter.getQuacks() + " times");
	}

	private void simulate(Quackable duck) {
		duck.quack();
	}

}
