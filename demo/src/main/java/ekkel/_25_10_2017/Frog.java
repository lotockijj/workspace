package ekkel._25_10_2017;

public class Frog extends Amphibian {

	public Frog(String name) {
		super(name);
	}
	
	@Override
	public void giveSound(){
		System.out.println("Kwack, kwack...");
	}
	
	public static void main(String[] args) {
		Frog frog = new Frog("Green frog");
		Amphibian.swim(frog);
		frog.giveSound();
	}

}
