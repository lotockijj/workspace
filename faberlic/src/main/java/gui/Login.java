package gui;

import com.dao.FabDao;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Login extends Application {
	FabDao fabDao;
	TextField userTF;
	PasswordField passwordField;

	@Override
	public void start(Stage primaryStage) throws Exception {

		fabDao = new FabDao();

		VBox vBox = new VBox();
		vBox.setPadding(new Insets(3, 3, 3, 3));
		vBox.setSpacing(3);

		userTF = new TextField();
		userTF.setPromptText("User name");
		HBox hBox1 = new HBox();
		hBox1.setPadding(new Insets(3, 3, 3, 3));
		hBox1.setSpacing(3);
		hBox1.setAlignment(Pos.CENTER);
		hBox1.getChildren().addAll(new Label("User:        "), userTF);

		passwordField = new PasswordField();
		passwordField.setPromptText("User password");
		HBox hBox2 = new HBox();
		hBox2.setPadding(new Insets(3, 3, 3, 3));
		hBox2.setSpacing(3);
		hBox2.setAlignment(Pos.CENTER);
		hBox2.getChildren().addAll(new Label("Password:"), passwordField);

		VBox mainBox = new VBox();
		mainBox.prefWidth(1000);
		HBox.setHgrow(hBox1, Priority.ALWAYS);
		mainBox.getChildren().addAll(hBox1, hBox2);

		vBox.getChildren().addAll(mainBox);

		Button btnOK = new Button("Ok");
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
		//setUserAgentStylesheet(STYLESHEET_CASPIAN);
		Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
		primaryStage.setX((primScreenBounds.getWidth() -  primaryStage.getWidth()) / 2);
		primaryStage.setY((primScreenBounds.getHeight() - primaryStage.getHeight()) / 2);
		primaryStage.setScene(scene);
		primaryStage.setTitle("User login.");
		primaryStage.centerOnScreen();
		primaryStage.show();

		btnOK.setOnAction(e ->{
			boolean confirmPassword = fabDao.validateUsersPassword(userTF.getText(), 
					passwordField.getText());
			try {
				if(confirmPassword) {
					User user = fabDao.createNewUser(userTF.getText());
					new FaberlicGoods(user);
					primaryStage.close();
				} else {
					AlertGui.createAlertError(null);
				}
			} catch (Exception e1) {
				AlertGui.createAlertError(e1);
			}	
		});

		btnCancel.setOnAction(e -> primaryStage.close());
	}

	public static void main(String[] args) {
		launch(args);
	}

}