package Adapter;

import java.util.Random;

public class TurkeyAdapter implements Duck {

	Turkey turkey;
	Random rand;

	public TurkeyAdapter(Turkey turkey){
		this.turkey = turkey;
		rand = new Random();
	}

	public void quack() {
		turkey.gobble();

	}

	public void fly() {
		for(int i = 0; i < rand.nextInt(5); i++){
			turkey.fly();
		}
//		if(rand.nextInt(5) == 0){
//			turkey.fly();
//		}
	}

}
