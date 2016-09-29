package patterns.of.patterns;

import java.util.Observer;

public class DuckSimulatorObserver {

	public static void main(String[] args) {
		DuckSimulatorObserver simulator = new DuckSimulatorObserver();
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
		
		System.out.println("\nDuck Simulator: With Observer");
		Quackologist quackologist = new Quackologist();
		flockOfDucks.registerObserver((Observer) quackologist);
		
		simulate(flockOfDucks);
		
		
		System.out.println("\nThe ducks quacked " + QuackCounter.getQuacks() + " times");
	}

	private void simulate(Quackable duck) {
		duck.quack();
	}

}
