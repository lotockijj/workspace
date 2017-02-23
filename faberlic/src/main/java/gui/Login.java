package gui;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.dao.FabDao;
import com.faberlic.Goods;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Login extends Application {

	Map<String, TextField> mapTextFields;
	FabDao fabDao;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		mapTextFields  = new HashMap<>();
		String[] names = new String[]{"User:", "Password:"};
		fabDao = new FabDao();

		VBox vBox = new VBox();
		vBox.setPadding(new Insets(3, 3, 3, 3));
		vBox.setSpacing(3);
		for(int i = 0; i < names.length; i++){
			HBox hBox1 = new HBox();
			hBox1.setPadding(new Insets(3, 3, 3, 3));
			hBox1.setSpacing(3);
			hBox1.setAlignment(Pos.CENTER_LEFT);
			hBox1.getChildren().add(new Label(names[i]));

			mapTextFields.put(names[i], new TextField());

			HBox hBox2 = new HBox();
			hBox2.setPadding(new Insets(3, 3, 3, 3));
			hBox2.setSpacing(3);
			hBox2.setAlignment(Pos.CENTER_RIGHT);
			hBox2.getChildren().add(mapTextFields.get(names[i]));

			HBox mainBox = new HBox();
			mainBox.prefWidth(1000);
			HBox.setHgrow(hBox1, Priority.ALWAYS);
			mainBox.getChildren().addAll(hBox1, hBox2);

			vBox.getChildren().addAll(mainBox);
		}
		
		Button btnOK = new Button("Ok");
		btnOK.setOnAction(e ->{
			validateUsersPassword(fabDao);
			try {
				new FaberlicGoods();
			} catch (Exception e1) {
				AlertGui.createAlertError(e1);
			}	
		});
		Button btnCancel = new Button("Cancel");
		HBox btnBox = new HBox();
		btnBox.setSpacing(10);
		btnBox.setPadding(new Insets(10, 10, 10, 10));
		btnBox.setAlignment(Pos.CENTER_RIGHT);
		btnBox.getChildren().addAll(btnOK, btnCancel);

		BorderPane layout = new BorderPane();/* layout */
		layout.setCenter(vBox);
		layout.setBottom(btnBox);

		Scene scene = new Scene(layout, 300, 150);
		Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
		primaryStage.setX((primScreenBounds.getWidth() -  primaryStage.getWidth()) / 2);
		primaryStage.setY((primScreenBounds.getHeight() - primaryStage.getHeight()) / 2);
		primaryStage.setScene(scene);
		primaryStage.setTitle("User login.");
		primaryStage.centerOnScreen();
		primaryStage.show();
	}
	
	private void validateUsersPassword(FabDao fabDao) {
		
	}

	public static void main(String[] args) {
		launch(args);
	}

}