package facade;

public class DvdPlayer {
	
	@Override
	public String toString(){
		return "one";
	}

	public void on() {
		System.out.println("DVD is on. ");
		
	}

	public void play(String movie) {
		System.out.println("DVD is playing.");
	}

	public void stop() {
		System.out.println("DVD is stop. ");
	}

	public void eject() {
		System.out.println("DVD is eject. ");
		
	}

	public void off() {
		System.out.println("DVD is off. ");
	}

}
