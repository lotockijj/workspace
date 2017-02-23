package gui;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class AlertGui {
	
	public static void createAlertError(Exception e){
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error!" );
		alert.setContentText(e.toString());
		alert.showAndWait();
	}

}
