package patterns.of.patterns;

import java.util.Observer;

public class RedHeadDuck implements Quackable {
	
	Observable observable;
	
	public RedHeadDuck(){}
	
	public RedHeadDuck(Observable observable){
		observable = new Observable(this);
	}
	
	public void quack() {
		System.out.println("Quack.");
		notifyObservers();
	}

	public void registerObserver(Observer observer) {
		observable.registerObserver(observer);
	}

	public void notifyObservers() {
		observable.notifyObservers();
	}

}
