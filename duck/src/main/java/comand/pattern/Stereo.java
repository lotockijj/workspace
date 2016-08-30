package comand.pattern;

public class Stereo {
	
	String name;
	
	public Stereo(String name){
		this.name = name;
	}
	
	public void on(){
		System.out.println("Stereo is on.");
	}
	
	public void off(){
		System.out.println("Stereo is off.");
	}
	
	public void setCD(){
		System.out.println("Stereo set CD.");
	}
	
	public void setVolume(int volume){
		System.out.println("Volume is set to " + volume + ".");
	}

}
