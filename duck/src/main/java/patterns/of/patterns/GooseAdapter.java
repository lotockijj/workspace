package patterns.of.patterns;

import java.util.Observer;

public class GooseAdapter implements Quackable {

	Goose goose;

	public GooseAdapter(Goose goose){
		this.goose = goose;
	}

	public void quack() {
		goose.honk();
	}

	public void registerObserver(Observer observer) {
		// TODO Auto-generated method stub
		
	}

	public void notifyObservers() {
		// TODO Auto-generated method stub
		
	}

}
