package patterns.of.patterns;

import java.util.Observer;

public class DuckCall implements Quackable {
	
	Observable observable;
	
	public DuckCall(){}
	
	public DuckCall(Observable observable){
		observable = new Observable(this);
	}

	public void quack() {
		System.out.println("Kwak");
	}

	public void registerObserver(Observer observer) {
		observable.registerObserver(observer);
	}

	public void notifyObservers() {
		observable.notifyObservers();
	}

}
