package patterns.of.patterns;

public class DuckSimulatorFactoryForGeese {

	public static void main(String[] args) {
		DuckSimulatorFactoryForGeese simulator = new DuckSimulatorFactoryForGeese();
		AbstractGeeseFactory geeseFactory = new GeeseFactory();
		
		simulator.simulate(geeseFactory);
	}
	
	private void simulate(AbstractGeeseFactory geeseFactory){
		Quackable gooseDuck =  geeseFactory.createGoose();
		
		System.out.println("\nGeese Simulator: With Abstract Factory");
		
		simulate(gooseDuck);
	}

	private void simulate(Quackable gooseDuck) {
		gooseDuck.quack();
		
	}

}
