package ekkel._20_10_2017;

public class Detergent {
	private Cleanser cleanser;
	
	public Detergent(Cleanser cleanser) {
		this.cleanser = cleanser;
	}
	public void scrub() {
		cleanser.append(" Detergent.scrub()");
		cleanser.scrub(); // Call base-class version
	}
	// Add methods to the interface:
	public void foam() { cleanser.append(" foam()"); }
	// Test the new class:
	public static void main(String[] args) {
		Cleanser cleanser = new Cleanser();
		Detergent x = new Detergent(cleanser);
		x.cleanser.dilute();
		x.cleanser.apply();
		x.cleanser.scrub();
		x.foam();
		System.out.println(x);
		System.out.println("Testing base class:");
		Cleanser.main(args); // !
	}

}
