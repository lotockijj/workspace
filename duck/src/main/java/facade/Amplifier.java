package facade;

public class Amplifier {

	public void on() {
		System.out.println("Amplifier on ... ");
	}

	public void setDvd(String movie) {
		System.out.println("Set DVD to: " + "\"" + movie + "\" ");
	}

	public void setSurroundSound() {
		System.out.println("Set surround sound... ");
	}

	public void setVolume(int i) {
		System.out.println("Volume is set to " + i);
		
	}

	public void off() {
		System.out.println("Amplifier is off. ");
		
	}

}
