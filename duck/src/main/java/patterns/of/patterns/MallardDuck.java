package patterns.of.patterns;

import java.util.Observer;

public class MallardDuck implements Quackable {
	
	Observable observable;
	
	public MallardDuck(){}
	
	public MallardDuck(Observable observable){
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
