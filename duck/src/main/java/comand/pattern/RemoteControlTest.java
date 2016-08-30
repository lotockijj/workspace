package comand.pattern;

public class RemoteControlTest {

	public static void main(String[] args) {
		SimpleRemoteControl remoteControl = new SimpleRemoteControl();
		
		Light light = new Light(null);
		LightOnCommand lightOn = new LightOnCommand(light);
		
		MoovingDoor mooving = new MoovingDoor();
		GarageDoorOpenCommand doorOpen = new GarageDoorOpenCommand(mooving);
		
		remoteControl.setCommand(lightOn);
		remoteControl.buttonWasPressed();
		
		remoteControl.setCommand(doorOpen);
		remoteControl.buttonWasPressed();
		
		LightOffCommand lightOff = new LightOffCommand(light);
		remoteControl.setCommand(lightOff);
		remoteControl.buttonWasPressed();
	}

}
