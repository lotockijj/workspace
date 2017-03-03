package com.main.fx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class MainScreen extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		Label inventoryManSys = new Label("Inventory Management System");
		HBox hBox = getHBox();
		hBox.setAlignment(Pos.BASELINE_LEFT);
		BorderPane layout = new BorderPane();/* layout */
		layout.setTop(inventoryManSys);
		
		Scene scene = new Scene(layout, 300, 150);
		primaryStage.setScene(scene);
		primaryStage.setTitle("User login.");
		primaryStage.centerOnScreen();
		primaryStage.show();
		
		//btnCancel.setOnAction(e -> primaryStage.close());
	}

	public static void main(String[] args) {
		launch(args);
	}

	private HBox getHBox() {
		HBox hBox = new HBox();
		hBox.setPadding(new Insets(5, 5, 5, 5));
		hBox.setSpacing(5);
		return hBox;
	}
	

}