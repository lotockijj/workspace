package comand.pattern;

public class RemoteLoaderPartyMode {

	public static void main(String[] args) {
		
		RemoteControl remoteControl = new RemoteControl();
		
		Light light = new Light("Living room. ");
		Stereo stereo = new Stereo("Stereo");
		
		LightOnCommand lightOn = new LightOnCommand(light);
		LightOffCommand lightOff = new LightOffCommand(light);
		
		StereoOnWithCDCommand stereoOn = new StereoOnWithCDCommand(stereo);
		StereoOffWithCDCommand stereoOff = new StereoOffWithCDCommand(stereo);
		
		Command[] partyOn = {lightOn, stereoOn};
		Command[] partyOff = {lightOff, stereoOff};
		
		MacroCommand partyOnMacro = new MacroCommand(partyOn);
		MacroCommand partyOffMacro = new MacroCommand(partyOff);
		
		remoteControl.setCommand(0, partyOnMacro, partyOffMacro);
		
		System.out.println(remoteControl);
		System.out.println("--- Pushing Macro On---");
		remoteControl.onButtonWasPushed(0);
		System.out.println("--- Pushing Macro Off---");
		remoteControl.offButtonWasPushed(0);
		System.out.println("--- Pushing undo button ---");
		remoteControl.undoButtonWasPushed();
	}

}
