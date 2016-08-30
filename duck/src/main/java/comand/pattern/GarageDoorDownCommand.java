package comand.pattern;

public class GarageDoorDownCommand implements Command {

	MoovingDoor doorDown;

	public GarageDoorDownCommand(MoovingDoor doorDown){
		this.doorDown = doorDown;
	}

	public void execute() {
		doorDown.down();
	}

	public void undo() {
		doorDown.up();
	}

}