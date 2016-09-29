package patterns.of.patterns;

import java.util.Observer;

public class RubberDuck implements Quackable {
	
	Observable observable;
	
	public RubberDuck(){}
	
	public RubberDuck(Observable observable){
		observable = new Observable(this);
	}

	public void quack() {
		System.out.println("Squeak");
	}

	public void registerObserver(Observer observer) {
		observable.registerObserver(observer);
	}

	public void notifyObservers() {
		observable.notifyObservers();
	}

}
