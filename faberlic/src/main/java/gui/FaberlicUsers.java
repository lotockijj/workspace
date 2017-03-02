package gui;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.dao.UserDAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FaberlicUsers extends Stage{

	private UserDAO userDao;
	private TableView<User> tableView; 
	ObservableList<User> userObserList;
	
	public FaberlicUsers() throws FileNotFoundException, IOException, SQLException{
		userDao = new UserDAO();
		
		Label label = new Label("Enter last_name");
		TextField textField = new TextField();
		Button btnSearch = new Button("Search");
		HBox hBox = new HBox();
		hBox.setPadding(new Insets(10, 10, 10, 10));
		hBox.setSpacing(10);
		hBox.setAlignment(Pos.TOP_CENTER);
		hBox.getChildren().addAll(label, textField, btnSearch);
		BorderPane root = new BorderPane();
		root.setTop(hBox);
		tableView = new TableView<>();
		
		TableColumn<User, Number> idTC = new TableColumn<User, Number>("id");
		idTC.setCellValueFactory(new PropertyValueFactory<>("id"));
		idTC.setMaxWidth(20);
		TableColumn<User, String> last_nameTC = new TableColumn<User, String>("last_name");
		last_nameTC.setCellValueFactory(new PropertyValueFactory<>("last_name"));
		last_nameTC.setMinWidth(70);
		TableColumn<User, String> first_nameTC = new TableColumn<User, String>("first_name");
		first_nameTC.setCellValueFactory(new PropertyValueFactory<>("first_name"));
		TableColumn<User, String> emailTC = new TableColumn<User, String>("email");
		emailTC.setCellValueFactory(new PropertyValueFactory<>("email"));
		emailTC.setMinWidth(180);
		TableColumn<User, String> passwordTC = new TableColumn<User, String>("password");
		passwordTC.setCellValueFactory(new PropertyValueFactory<>("password"));
		tableView.getColumns().addAll(idTC, last_nameTC, first_nameTC, emailTC, passwordTC);
		VBox vBox = new VBox();
		vBox.setSpacing(10);
		vBox.setPadding(new Insets(5, 5, 5, 5));
		vBox.getChildren().add(tableView);
		root.setCenter(vBox);
		Scene scene = new Scene(root, 440, 250);
		this.setTitle("Goods search application.");
		this.setScene(scene);
		this.show();
		List<User> list = userDao.getAllUsers();
		userObserList = FXCollections.observableArrayList(list);
		tableView.setItems(userObserList);
	}
}
