package com.main.fx;

import java.util.ArrayList;
import java.util.Optional;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class AddOrModifyProduct extends Stage{
	MainScreen mainScreen;
	TableView<Part> tableParts;
	TableView<Part> bottomTableProduct;
	ObservableList<Part> observableList;
	ObservableList<Part> observableList2;
	ArrayList<Part> tempList;
	TextField idTF, nameTF, invTF, priceCosTF, maxTF, minTF;

	public AddOrModifyProduct(MainScreen mainScreen, Product selectedProduct, String title){
		this.mainScreen = mainScreen;
		tempList = new ArrayList<>();
		HBox mainBox = createHBox(20, 20);
		mainBox.setBorder(new Border(new BorderStroke(Color.GRAY, 
				BorderStrokeStyle.SOLID, new CornerRadii(10), BorderWidths.DEFAULT)));

		HBox wholeHBox = createHBox(10, 10);

		//starting to create left part
		Label headName = new Label(title);
		headName.setFont(Font.font("Default", FontWeight.BOLD, 18));

		HBox hBoxLeft = createHBox(15, 15);
		hBoxLeft.setAlignment(Pos.BASELINE_LEFT);
		hBoxLeft.getChildren().addAll(headName);

		GridPane grid = new GridPane();
		grid.setHgap(5);
		grid.setVgap(5);
		grid.setPadding(new Insets(20, 20, 20, 20));

		Label idL = new Label("ID");
		grid.add(idL, 0, 0);

		idTF = new TextField();
		idTF.setText("Auto Gen Disabled");
		idTF.setEditable(false);
		grid.add(idTF, 1, 0);

		Label nameL = new Label("Name");
		grid.add(nameL, 0, 1);

		nameTF = new TextField();
		grid.add(nameTF, 1, 1);

		Label inv = new Label("Inv");
		grid.add(inv, 0, 2);

		invTF = new TextField();
		grid.add(invTF, 1, 2);

		Label priceCostL = new Label("Price");
		grid.add(priceCostL, 0, 3);

		priceCosTF = new TextField();
		grid.add(priceCosTF, 1, 3);

		Label maxL = new Label("Max");
		grid.add(maxL, 0, 4);

		// hBox
		HBox hBoxForMaxMin = createHBox(3, 3);
		maxTF = new TextField();
		maxTF.setMaxWidth(80);

		Label minL = new Label("            Min");
		hBoxForMaxMin.setAlignment(Pos.CENTER_LEFT);
		hBoxForMaxMin.getChildren().addAll(maxTF, minL);
		grid.add(hBoxForMaxMin, 1, 4);

		minTF = new TextField();
		minTF.setMaxWidth(80);
		grid.add(minTF, 3, 4);

		BorderPane layoutLeft = new BorderPane();
		layoutLeft.setTop(hBoxLeft);
		layoutLeft.setCenter(grid);
		// ending to create left part

		VBox mainVB = new VBox();
		mainVB.setPadding(new Insets(10, 10, 10, 10));

		//creating center top hBox for top table.
		VBox topVB = new VBox();
		HBox topTableHB = createHBox(10, 10);
		topTableHB.setAlignment(Pos.CENTER);
		Button btnSearch = new Button("Search");
		TextField searchTF = new TextField();
		topTableHB.getChildren().addAll(btnSearch, searchTF);
		HBox topTable = createHBox(10, 10);
		tableParts = createTable();//new TableView<>();
		observableList = FXCollections.observableArrayList(mainScreen.parts);
		tableParts.setItems(observableList);

		topTable.getChildren().add(tableParts);
		HBox hBoxForButton = createHBox(5, 5);
		hBoxForButton.setAlignment(Pos.CENTER_RIGHT);
		Button btnAdd = new Button("Add");
		hBoxForButton.getChildren().add(btnAdd);
		topVB.getChildren().addAll(topTableHB, topTable, hBoxForButton);
		//ending creating center top hBox for top table.

		// creating center bottom hBox for bottom table.
		VBox bottomVB = new VBox();

		HBox bottomTableHB = createHBox(10, 10);
		Label bottomSearchLabel = new Label("Search");
		TextField bottomSearchTF = new TextField();
		bottomTableHB.getChildren().addAll(bottomSearchLabel, bottomSearchTF);
		HBox bottomTable = createHBox(10, 10);
		bottomTableProduct = createTable();
		observableList2 = FXCollections.observableArrayList(tempList);
		bottomTableProduct.setItems(observableList2);
		bottomTable.getChildren().add(bottomTableProduct);

		HBox hbDeleteBtn = createHBox(10, 10);
		hbDeleteBtn.setAlignment(Pos.CENTER_RIGHT);
		Button btnDelete = new Button("Delete");
		hbDeleteBtn.getChildren().add(btnDelete);

		HBox hbBtnSaveCancel = createHBox(10, 10);
		hbBtnSaveCancel.setAlignment(Pos.CENTER_RIGHT);
		Button btnSave = new Button("Save");
		Button btnCancel = new Button("Cancel");
		hbBtnSaveCancel.getChildren().addAll(btnSave, btnCancel);

		bottomVB.getChildren().addAll(bottomTable, hbDeleteBtn, hbBtnSaveCancel);
		//ending creating center top hBox for bottom table.

		mainVB.getChildren().addAll(topVB, bottomVB);

		wholeHBox.getChildren().addAll(layoutLeft, mainVB);
		wholeHBox.setBorder(new Border(new BorderStroke(Color.GRAY, 
				BorderStrokeStyle.SOLID, new CornerRadii(10)
				/*CornerRadii.EMPTY*/, BorderWidths.DEFAULT)));
		HBox mainHB = createHBox(10, 10);
		mainHB.getChildren().add(wholeHBox);
		Scene scene = new Scene(mainHB, 920, 550);
		this.setScene(scene);
		this.centerOnScreen();
		this.show();

		if(selectedProduct != null){
			nameTF.setText(selectedProduct.getName());
			invTF.setText(Integer.toString(selectedProduct.getInstock()));
			priceCosTF.setText(Double.toString(selectedProduct.getPrice()));
			maxTF.setText(Integer.toString(selectedProduct.getMax()));
			minTF.setText(Integer.toString(selectedProduct.getMin()));
			tempList = selectedProduct.getParts();
			refreshGui();
		}
		
		btnSearch.setOnAction(e -> {
			ArrayList<Part> tempListParts = null;
			String searchingName = searchTF.getText();
			if(searchingName != null && searchingName.trim().length() > 0){
				tempListParts = getListSearchingNamesParts(searchingName);
				observableList = FXCollections.observableArrayList(tempListParts);
			} else {
				observableList = FXCollections.observableArrayList(mainScreen.parts);
			}
			tableParts.setItems(observableList);
		});
		
		btnAdd.setOnAction(e -> {
			Part selectedPart = tableParts.getSelectionModel().getSelectedItem();
			if(!tempList.contains(selectedPart)){
				tempList.add(selectedPart);
				refreshGui();
			} 
		});
		
		btnDelete.setOnAction(e -> {
			int selectedId = bottomTableProduct.getSelectionModel().getSelectedIndex();
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Delete goods ");
			alert.setContentText("Are you sure you want to delete " + (selectedId + 1) + " part?");
			Optional<ButtonType> result = alert.showAndWait();
			if ((result.isPresent()) && (result.get() == ButtonType.OK)) {
				tempList.remove(selectedId);
			} 
			refreshGui();
		});
		
		btnSave.setOnAction(e -> {
			Product product = new Product();
			product.setParts(tempList);
			product.setName(nameTF.getText());
			product.setInstock(Integer.parseInt(invTF.getText()));
			product.setPrice(Double.parseDouble(priceCosTF.getText()));
			product.setMax(Integer.parseInt(maxTF.getText()));
			product.setMin(Integer.parseInt(minTF.getText()));
			if(title.equals("Modify Product")){
				mainScreen.products.set(mainScreen.tableProducts.
						getSelectionModel().getSelectedIndex(), product);
			} else{
				mainScreen.products.add(product);
			}
			mainScreen.refreshTables();
				this.close();
		});
		
		btnCancel.setOnAction(e -> this.close());
	}

	private ArrayList<Part> getListSearchingNamesParts(String name) {
		ArrayList<Part> tempList = new ArrayList<>();
		for(Part p : mainScreen.parts){
			if(p.getName().equals(name)){
				tempList.add(p);
			}
		}
		return tempList;
	}

	private void refreshGui() {
		observableList2 = FXCollections.observableArrayList(tempList);
		bottomTableProduct.setItems(observableList2);
	}

	private TableView<Part> createTable() {
		TableView<Part> table = new TableView<>();
		table.setMinWidth(430);
		TableColumn<Part, Integer> partId = new TableColumn<>("Part id");
		partId.setMaxWidth(100);
		partId.setSortable(false);
		partId.setCellValueFactory(column-> 
		new ReadOnlyObjectWrapper<Integer>(table.getItems().indexOf(column.getValue())+1));
		TableColumn<Part, String> partName= new TableColumn<>("Part name");
		partName.setMaxWidth(100);
		partName.setCellValueFactory(new PropertyValueFactory<>("name"));
		TableColumn<Part, Integer> inventoryLevel = new TableColumn<>("Inventory level");
		inventoryLevel.setMinWidth(150);
		inventoryLevel.setCellValueFactory(new PropertyValueFactory<>("instock"));
		TableColumn<Part, Double> priceCost = new TableColumn<>("Price per Unit");
		priceCost.setMinWidth(150);
		priceCost.setCellValueFactory(new PropertyValueFactory<>("price"));
		table.getColumns().addAll(partId, partName, inventoryLevel, priceCost);
		return table;
	}

	private HBox createHBox(int pad, int spac) {
		HBox hBox = new HBox();
		hBox.setPadding(new Insets(pad, pad, pad, pad));
		hBox.setSpacing(spac);
		return hBox;
	}

}
