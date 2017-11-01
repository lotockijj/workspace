package ekkel._25_10_2017;

public class Amphibian {
	private String name;
	
	public Amphibian(String name){
		this.name = name;
	}
	
	public static void swim(Amphibian amp){
		System.out.println("I swim " + amp);
	}
	
	public void giveSound(){
		System.out.println("Give some sound...");
	}

	@Override
	public String toString() {
		return " ( " + name + " ); ";
	}
	
	

}
