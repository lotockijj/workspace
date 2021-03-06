package com.main.fx;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javafx.application.Application;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class MainScreen extends Application {
	List<Part> parts;
	List<Product> products;
	ObservableList<Part> observableListParts;
	ObservableList<Product> observableListProducts;
	TableView<Part> tableParts;
	TableView<Product> tableProducts;
	int selectedId;

	@Override
	public void start(Stage primaryStage) throws Exception {
		parts = new ArrayList<>();
		products = new ArrayList<>();
		//Create notice "Inventory Management System" and position it. 
		Label inventoryManSys = new Label("Inventory Management System");
		inventoryManSys.setFont(Font.font("Default", FontWeight.BOLD, 20));
		HBox hBox = createHBox(15, 15);
		hBox.setAlignment(Pos.BASELINE_LEFT);
		hBox.getChildren().add(inventoryManSys);

		// Creating Parts management system.
		HBox hBoxParts = createHBox(10, 10);
		hBoxParts.setBorder(new Border(new BorderStroke(Color.GRAY, 
				BorderStrokeStyle.SOLID, new CornerRadii(10), BorderWidths.DEFAULT)));
		BorderPane borderParts = new BorderPane();
		Label partsL = new Label("Parts");
		partsL.setFont(Font.font("Default", FontWeight.BOLD, 16));
		Button btnSearch = new Button("Search");
		TextField tFSearch = new TextField();
		HBox hBPartsTop = createHBox(10, 10);
		hBPartsTop.getChildren().addAll(partsL, new Label("            "
				+ "                                "), btnSearch, tFSearch);

		Button btnAddPart = new Button("Add");
		Button btnModifyPart = new Button("Modify");
		Button btnDelete = new Button("Delete");
		HBox hBoxForButtons = createHBox(10, 10);
		hBoxForButtons.setAlignment(Pos.BASELINE_RIGHT);
		hBoxForButtons.getChildren().addAll(btnAddPart, btnModifyPart, btnDelete);

		borderParts.setTop(hBPartsTop);
		borderParts.setBottom(hBoxForButtons);

		hBoxParts.getChildren().add(borderParts);

		HBox hBoxPartsMain = createHBox(10, 10);
		hBoxPartsMain.getChildren().add(hBoxParts);

		//creating table for parts.

		tableParts = new TableView<>();
		TableColumn<Part, Number> partId = new TableColumn<Part, Number>("Part id");
		partId.setCellValueFactory(column-> 
		new ReadOnlyObjectWrapper<Number>(tableParts.getItems().indexOf(column.getValue())+1));
		TableColumn<Part, String> partName= new TableColumn<Part, String>("Part name");
		partName.setCellValueFactory(new PropertyValueFactory<>("name"));
		TableColumn<Part, Integer> inventoryLevel = new TableColumn<Part, Integer>("Inventory level");
		inventoryLevel.setCellValueFactory(new PropertyValueFactory<>("instock"));
		TableColumn<Part, Double> priceCost = new TableColumn<Part, Double>("Price/Cost" + "\n" + "per Unit");
		priceCost.setCellValueFactory(new PropertyValueFactory<>("price"));

		tableParts.getColumns().addAll(partId, partName, inventoryLevel, priceCost);
		tableParts.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		borderParts.setCenter(tableParts);

		// Creating Products management system.
		HBox hBoxProducts = createHBox(10, 10);
		hBoxProducts.setBorder(new Border(new BorderStroke(Color.GRAY, 
				BorderStrokeStyle.SOLID, new CornerRadii(10)
				/*CornerRadii.EMPTY*/, BorderWidths.DEFAULT)));
		BorderPane borderProducts = new BorderPane();
		Label productsL = new Label("Products");
		productsL.setFont(Font.font("Default", FontWeight.BOLD, 16));
		Button btnSearchPr = new Button("Search");
		TextField tFSearchPr = new TextField();
		HBox hBPartsTopPr = createHBox(10, 10);
		hBPartsTopPr.getChildren().addAll(productsL, new Label("            "
				+ "                                "), btnSearchPr, tFSearchPr);

		Button btnAddPr = new Button("Add");
		Button btnModifyPr = new Button("Modify");
		Button btnDeletePr = new Button("Delete");
		HBox hBoxForButtonsPr = createHBox(10, 10);
		hBoxForButtonsPr.setAlignment(Pos.BASELINE_RIGHT);
		hBoxForButtonsPr.getChildren().addAll(btnAddPr, btnModifyPr, btnDeletePr);

		borderProducts.setTop(hBPartsTopPr);
		borderProducts.setBottom(hBoxForButtonsPr);

		hBoxProducts.getChildren().add(borderProducts);

		HBox hBoxProductsMain = createHBox(10, 10);
		hBoxProductsMain.getChildren().add(hBoxProducts);

		//creating table for products
		tableProducts = new TableView<>();
		TableColumn<Product, Integer> productId = new TableColumn<>("Product id");
		productId.setCellValueFactory(column-> 
		new ReadOnlyObjectWrapper<Integer>(tableProducts.getItems().indexOf(column.getValue())+1));
		TableColumn<Product, String> productName= new TableColumn<>("Product name");
		productName.setCellValueFactory(new PropertyValueFactory<>("name"));
		TableColumn<Product, Integer> inventoryLevelPr = new TableColumn<>("Inventory level");
		inventoryLevelPr.setCellValueFactory(new PropertyValueFactory<>("instock"));
		TableColumn<Product, Double> priceCostPr = new TableColumn<>("Price/Cost" + "\n" + "per Unit");
		priceCostPr.setCellValueFactory(new PropertyValueFactory<>("price"));

		tableProducts.getColumns().addAll(productId, productName, inventoryLevelPr, priceCostPr);
		tableProducts.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		borderProducts.setCenter(tableProducts);

		//Creating button for exit.
		Button btnExit = new Button("Exit");
		HBox hBoxForExit = createHBox(10, 10);
		hBoxForExit.setAlignment(Pos.CENTER_RIGHT);
		hBoxForExit.getChildren().add(btnExit);

		BorderPane layout = new BorderPane();/* layout */
		layout.setTop(hBox);
		layout.setLeft(hBoxPartsMain);
		layout.setCenter(hBoxProductsMain);
		layout.setBottom(hBoxForExit);

		Scene scene = new Scene(layout, 1180, 400);
		primaryStage.setScene(scene);
		//primaryStage.setTitle();
		primaryStage.centerOnScreen();
		primaryStage.show();

		btnExit.setOnAction(e -> primaryStage.close());
		btnAddPart.setOnAction(e -> new AddOrModifyPart(MainScreen.this, null,  "Add part   "));
		btnModifyPart.setOnAction(e -> {
			Part selectedPart = tableParts.getSelectionModel().getSelectedItem();
			selectedId = tableParts.getSelectionModel().getSelectedIndex();
			new AddOrModifyPart(MainScreen.this, selectedPart, "Modify part  ");	
		});
		btnAddPr.setOnAction(e -> new AddOrModifyProduct(MainScreen.this, null, "Add Product"));
		btnModifyPr.setOnAction(e -> {
			Product selectedProduct = tableProducts.getSelectionModel().getSelectedItem();
			new AddOrModifyProduct(MainScreen.this, selectedProduct, "Modify Product");	
		});
		btnSearch.setOnAction(e -> {
			ArrayList<Part> tempListParts = null;
			String searchingName = tFSearch.getText();
			if(searchingName != null && searchingName.trim().length() > 0){
				tempListParts = getListSearchingNamesParts(searchingName);
				observableListParts = FXCollections.observableArrayList(tempListParts);
			} else {
				observableListParts = FXCollections.observableArrayList(parts);
			}
			tableParts.setItems(observableListParts);
		});
		btnSearchPr.setOnAction(e -> {
			ArrayList<Product> tempListProducts = null;
			String searchingName = tFSearchPr.getText();
			if(searchingName != null && searchingName.trim().length() > 0){
				tempListProducts = getListSearchingNamesProducts(searchingName);
				observableListProducts = FXCollections.observableArrayList(tempListProducts);
			}  else{
				observableListProducts = FXCollections.observableArrayList(products);
			}
			tableProducts.setItems(observableListProducts);
		});
		btnDelete.setOnAction(e -> {
			selectedId = tableParts.getSelectionModel().getSelectedIndex();
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Delete goods ");
			alert.setContentText("Are you sure you want to delete part id " + (selectedId + 1) + "?");
			Optional<ButtonType> result = alert.showAndWait();
			if (result.isPresent() && result.get() == ButtonType.OK) {
				parts.remove(selectedId);
			} 
			refreshTables();
		});
		btnDeletePr.setOnAction(e -> {
			selectedId = tableProducts.getSelectionModel().getSelectedIndex();
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Delete product");
			alert.setContentText("Are you sure you want to delete product id " + (selectedId + 1) + "?");
			Optional<ButtonType> result = alert.showAndWait();
			if(result.isPresent() && result.get() == ButtonType.OK){
				System.out.println("Name: " + products.get(selectedId).getName() + ", Index: " + selectedId);
				products.remove(selectedId);
			}
			refreshTables();
		});
		//btnModify
	}

	public static void main(String[] args) {
		launch(args);
	}

	private HBox createHBox(int pad, int spac) {
		HBox hBox = new HBox();
		hBox.setPadding(new Insets(pad, pad, pad, pad));
		hBox.setSpacing(spac);
		return hBox;
	}

	public void refreshTables() {
		observableListParts = FXCollections.observableArrayList(parts);
		tableParts.setItems(observableListParts);
		observableListProducts = FXCollections.observableArrayList(products);
		tableProducts.setItems(observableListProducts);
	}

	private ArrayList<Part> getListSearchingNamesParts(String name) {
		ArrayList<Part> tempList = new ArrayList<>();
		for(Part p : parts){
			if(p.getName().equals(name)){
				tempList.add(p);
			}
		}
		return tempList;
	}
	
	private ArrayList<Product> getListSearchingNamesProducts(String name) {
		ArrayList<Product> tempList = new ArrayList<>();
		for(Product p : products){
			if(p.getName().equals(name)){
				tempList.add(p);
			}
		}
		return tempList;
	}

}