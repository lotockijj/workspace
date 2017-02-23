package gui;

import javafx.application.Application;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.apache.derby.impl.sql.execute.CreateConstraintConstantAction;

import com.dao.FabDao;
import com.faberlic.Goods;

// for testing fabDao = null;
public class FaberlicGoods extends Application{

	FabDao fabDao;
	TableView<Goods> tableView;
	ObservableList<Goods> goods;
	int selectedId;

	public void startApplication(Stage primaryStage) throws Exception {
		fabDao = new FabDao();

		Label label = new Label("Enter article");
		TextField textField = new TextField();

		Button btn = new Button();
		btn.setText("Search");

		HBox hBox = new HBox();
		hBox.setPadding(new Insets(10, 10, 10, 10));
		hBox.setSpacing(10);
		hBox.setAlignment(Pos.TOP_CENTER);
		hBox.getChildren().addAll(label, textField, btn);

		BorderPane root = new BorderPane();
		root.setTop(hBox);

		tableView = new TableView<Goods>(); //table.setItems(teamMembers);

		TableColumn<Goods, Number> id = new TableColumn<Goods, Number>("id");
		id.setSortable(false);
		id.setMaxWidth(50);
		id.setCellValueFactory(column-> 
		new ReadOnlyObjectWrapper<Number>(tableView.getItems().indexOf(column.getValue())+1));

		TableColumn<Goods, String> discountTC = new TableColumn<Goods, String>("discount");
		discountTC.setCellValueFactory(new PropertyValueFactory<>("discount"));
		discountTC.setMinWidth(180);

		TableColumn<Goods, String>  pageTC = new TableColumn<Goods, String> ("page");
		pageTC.setCellValueFactory(new PropertyValueFactory<>("page"));
		pageTC.setMinWidth(80);

		TableColumn<Goods, String>  articleTC = new TableColumn<Goods, String> ("article");
		articleTC.setCellValueFactory(new PropertyValueFactory<>("article"));
		articleTC.setMinWidth(180);

		TableColumn<Goods, String>  nameTC = new TableColumn<Goods, String> ("name");
		nameTC.setCellValueFactory(new PropertyValueFactory<>("name"));
		nameTC.setMinWidth(300);

		TableColumn<Goods, String> priceCatalogCombined = new TableColumn<Goods, String>("price catalog");


		TableColumn<Goods, BigDecimal> priceCatalogTC = new TableColumn<Goods, BigDecimal>("was");
		priceCatalogTC.setCellValueFactory(new PropertyValueFactory<>("priceCatalog"));

		TableColumn<Goods, BigDecimal>  theSameTC = new TableColumn<Goods, BigDecimal> ("is");
		theSameTC.setCellValueFactory(new PropertyValueFactory<>("theSame"));

		priceCatalogCombined.getColumns().addAll(priceCatalogTC, theSameTC);

		TableColumn<Goods, String> allowanceTC = new TableColumn<Goods, String>("allowance");
		allowanceTC.setCellValueFactory(new PropertyValueFactory<>("allowance"));
		TableColumn<Goods, BigDecimal>   priceStoreTC = new TableColumn<Goods, BigDecimal>  ("price store");
		priceStoreTC.setCellValueFactory(new PropertyValueFactory<>("priceStore"));
		TableColumn<Goods, Float> ballConsultantTC = new TableColumn<Goods, Float>("ball consultant");
		ballConsultantTC.setCellValueFactory(new PropertyValueFactory<>("ballConsultant"));
		TableColumn<Goods, BigDecimal>   priceBuyerTC = new TableColumn<Goods, BigDecimal>  ("price buyer");
		priceBuyerTC.setCellValueFactory(new PropertyValueFactory<>("priceBuyer"));
		TableColumn<Goods, Float> ballBuyerTC = new TableColumn<Goods, Float>();
		ballBuyerTC.setCellValueFactory(new PropertyValueFactory<>("ballBuyer"));

		// making text vertical in column. 
		Label label1 = new Label("ball buyer");
		label1.setRotate(-90);
		label1.setMinHeight(200);
		Group g = new Group(label1);
		ballBuyerTC.setGraphic(g);

		tableView.getColumns().addAll(id, discountTC, pageTC, articleTC, nameTC, priceCatalogCombined, 
				allowanceTC, priceStoreTC, ballConsultantTC, priceBuyerTC, ballBuyerTC);

		VBox vBox = new VBox();
		vBox.setSpacing(10);
		vBox.setPadding(new Insets(10, 10, 10, 10));
		vBox.getChildren().add(tableView);

		Button btnAddGoods = new Button("Add goods");
		Button btnUpdateGoods = new Button("Update goods");
		Button btnDeleteGoods = new Button("Delete goods");

		HBox bottomPannel = new HBox();
		bottomPannel.setSpacing(10);
		bottomPannel.setPadding(new Insets(10, 10, 10, 10));
		bottomPannel.getChildren().addAll(btnAddGoods, btnUpdateGoods, btnDeleteGoods);
		root.setBottom(bottomPannel);
		btnAddGoods.setOnAction(e -> {
			AddDialogFX addDialogFX = new AddDialogFX(FaberlicGoods.this, fabDao, null, false);
			addDialogFX.show();
		});
		btnUpdateGoods.setOnAction(e ->{
			try{
				Goods selectedGoods = tableView.getSelectionModel().getSelectedItem();
				selectedId = tableView.getSelectionModel().getSelectedIndex() + 1;
				AddDialogFX addDialogFX = new AddDialogFX(FaberlicGoods.this, fabDao, selectedGoods, true);
				addDialogFX.show();
			} catch (NullPointerException exc){
				AlertGui.createAlertError(exc);
			}
		});
		btnDeleteGoods.setOnAction(e -> {
			try{
				selectedId = tableView.getSelectionModel().getSelectedIndex() + 1;
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Delete goods ");
				alert.setContentText("Are you sure you want delete goods id " + selectedId);
				Optional<ButtonType> result = alert.showAndWait();
				if ((result.isPresent()) && (result.get() == ButtonType.OK)) {
					fabDao.deleteGoods(selectedId);
				} 
				this.refreshFaberlicGoods();
			} catch (Exception exc){
				AlertGui.createAlertError(exc);
			}
		});

		root.setCenter(vBox);
		Scene scene = new Scene(root, 1300, 450);

		primaryStage.setTitle("Goods search application.");
		primaryStage.setScene(scene);
		primaryStage.show();

		btn.setOnAction(e -> {
			List<Goods> listGoods = null;
			String searchingName = textField.getText();
			if(searchingName != null && searchingName.trim().length() > 0){
				try {
					listGoods = fabDao.searchGoods(searchingName); //3494
				} catch (Exception e1) {
					AlertGui.createAlertError(e1);
				}
			} else {
				listGoods = fabDao.getAllGoods();
			}

			goods = FXCollections.observableArrayList(listGoods);
			tableView.setItems(goods);


			//			if(ballBuyerTC.isVisible()){
			//				ballBuyerTC.setVisible(false);
			//			} else {
			//				ballBuyerTC.setVisible(true);
			//			}
			//			if(discountTC.isVisible()){
			//				discountTC.setVisible(false);
			//			} else {
			//				discountTC.setVisible(true);
			//			}
		});
	}

	public static void main(String[] args) {
		launch(args);
	}

	public void refreshFaberlicGoods() {
		try {
			List<Goods> listGoods = fabDao.getAllGoods();
			goods = FXCollections.observableArrayList(listGoods);
			tableView.setItems(goods);
		} catch(Exception e){
			AlertGui.createAlertError(e);
		}
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		startApplication(primaryStage);
	}
}
