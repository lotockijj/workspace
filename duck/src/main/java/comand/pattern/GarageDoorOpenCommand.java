package comand.pattern;

public class GarageDoorOpenCommand implements Command {
	
	MoovingDoor doorUp;
	
	public GarageDoorOpenCommand(MoovingDoor doorUp){
		this.doorUp = doorUp;
	}

	public void execute() {
		doorUp.up();
	}

	public void undo() {
		doorUp.down();
	}

}
