package encapsulating.algorithms;

public abstract class CaffeineBeverage {
	
	final void prepareRecipe(){
		boilWater();
		brew();
		pourInCup();
		addCondiments();
		hook();
	}
	
	abstract void brew();

	abstract void addCondiments();
	
	private void boilWater() {
		System.out.println("Boiling water. ");
	}

	private void pourInCup() {
		System.out.println("Pouring into cup. ");
	}
	
	void hook(){
		// do something... 
	} // The subclass may override or don't. 
	// if don't - it will be default like this
	// if override - it will be their own implementation. 

}
