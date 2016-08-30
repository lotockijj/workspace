package comand.pattern;

public class RemoteLoader {

	public static void main(String[] args) {
		RemoteControl remoteControl = new RemoteControl();
		
		Light livingRoomLight = new Light("Living room. ");
		//Light kitchenLight = new Light("Kitchen. ");
		//MoovingDoor garegeDoor = new MoovingDoor();
		//Stereo stereo = new Stereo("Living room.");
		
		LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoomLight);
		LightOffCommand livingRoomLightOff = new LightOffCommand(livingRoomLight);
		//LightOnCommand kitchenLightOn = new LightOnCommand(kitchenLight);
		//LightOffCommand kitchenLightOff = new LightOffCommand(kitchenLight);
		
		//GarageDoorOpenCommand garageDoorUp = new GarageDoorOpenCommand(garegeDoor);
		//GarageDoorDownCommand garageDoorDown = new GarageDoorDownCommand(garegeDoor);
		
		//StereoOnWithCDCommand stereoOnWithCD = new StereoOnWithCDCommand(stereo);
		//StereoOffWithCDCommand stereoOffWithCD = new StereoOffWithCDCommand(stereo);
		
		remoteControl.setCommand(0, livingRoomLightOn, livingRoomLightOff);
		//remoteControl.setCommand(1, kitchenLightOn, kitchenLightOff);
		//remoteControl.setCommand(2, garageDoorUp, garageDoorDown);
		//remoteControl.setCommand(3, stereoOnWithCD, stereoOffWithCD);
		
		//System.out.println(remoteControl);
		
		//remoteControl.onButtonWasPushed(0);
		//remoteControl.offButtonWasPushed(0);
		
		/*remoteControl.onButtonWasPushed(1);
		remoteControl.offButtonWasPushed(1);
		
		remoteControl.onButtonWasPushed(2);
		remoteControl.offButtonWasPushed(2);
		
		remoteControl.onButtonWasPushed(3);
		remoteControl.offButtonWasPushed(3); */


		remoteControl.onButtonWasPushed(0);
		remoteControl.offButtonWasPushed(0);
		System.out.println(remoteControl);
		remoteControl.undoButtonWasPushed();
		remoteControl.offButtonWasPushed(0);
		remoteControl.onButtonWasPushed(0);
		System.out.println(remoteControl);
		remoteControl.undoButtonWasPushed();
	}

}
