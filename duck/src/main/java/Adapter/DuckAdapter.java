package Adapter;

public class DuckAdapter implements Turkey {
	
	Duck duck;
	
	public DuckAdapter(Duck duck){
		this.duck = duck; 
	}

	public void gobble() {
		duck.fly();
	}

	public void fly() {
		duck.quack();
	}

}
