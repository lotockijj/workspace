package gui;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Date;
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

public class TableAuditHistory extends Stage{
	private AuditHistoryDAO auditHistoryDao;
	private TableView<UsersHistory> tableView; 
	ObservableList<UsersHistory> auditHistoryObserList;
	
	public TableAuditHistory() throws FileNotFoundException, IOException, SQLException{
		auditHistoryDao = new AuditHistoryDAO();
		
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
		
		TableColumn<UsersHistory, Number> idTC = new TableColumn<UsersHistory, Number>("id");
		idTC.setCellValueFactory(new PropertyValueFactory<>("id"));
		idTC.setMaxWidth(30);
		TableColumn<UsersHistory, String> last_nameTC = new TableColumn<UsersHistory, String>("last_name");
		last_nameTC.setCellValueFactory(new PropertyValueFactory<>("last_name"));
		last_nameTC.setMinWidth(70);
		TableColumn<UsersHistory, String> first_nameTC = new TableColumn<UsersHistory, String>("first_name");
		first_nameTC.setCellValueFactory(new PropertyValueFactory<>("first_name"));
		TableColumn<UsersHistory, String> actionTC = new TableColumn<UsersHistory, String>("action");
		actionTC.setCellValueFactory(new PropertyValueFactory<>("action"));
		actionTC.setMinWidth(180);
		TableColumn<UsersHistory, Date> actionDateTC = new TableColumn<UsersHistory, Date>("action date");
		actionDateTC.setCellValueFactory(new PropertyValueFactory<>("action_date_time"));
		actionDateTC.setMinWidth(100);
		tableView.getColumns().addAll(idTC, last_nameTC, first_nameTC, actionTC, actionDateTC);
		VBox vBox = new VBox();
		vBox.setSpacing(10);
		vBox.setPadding(new Insets(5, 5, 5, 5));
		vBox.getChildren().add(tableView);
		root.setCenter(vBox);
		Scene scene = new Scene(root, 500, 250);
		this.setTitle("Goods search application.");
		this.setScene(scene);
		this.show();
		List<UsersHistory> list = auditHistoryDao.getTheWholeAuditHistory();
		auditHistoryObserList = FXCollections.observableArrayList(list);
		tableView.setItems(auditHistoryObserList);
	}
}
