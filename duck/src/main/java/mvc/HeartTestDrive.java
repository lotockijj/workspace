package mvc;

public class HeartTestDrive {
	
	public static void main (String[] args) {
		
		HeartModelInterface heartModel = new HeartModel();
		ControllerInterface model = new HeartController(heartModel);
	}
}