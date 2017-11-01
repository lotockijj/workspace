package ekkel._20_10_2017;

public class Clean extends Cleanser {
	
	@Override
	public void scrub(){
		append(" Clean.scrub()");
		super.scrub();
	}
	
	public void sterilize(){
		append(" sterilize()");
	}
	
	public static void main(String[] args) {
		Clean x = new Clean();
		x.dilute();
		x.apply();
		x.scrub();
		x.sterilize();
		System.out.println(x);
		System.out.println("Testing base class:");
		Detergent.main(args); // !
	}
}
