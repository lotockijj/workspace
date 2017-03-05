package com.main.fx;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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

	public AddOrModifyProduct(String title){
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

		TextField idTF = new TextField();
		idTF.setText("Auto Gen Disabled");
		idTF.setEditable(false);
		grid.add(idTF, 1, 0);
		
		Label nameL = new Label("Name");
		grid.add(nameL, 0, 1);

		TextField nameTF = new TextField();
		grid.add(nameTF, 1, 1);

		Label inv = new Label("Inv");
		grid.add(inv, 0, 2);

		TextField invTF = new TextField();
		grid.add(invTF, 1, 2);

		Label priceCostL = new Label("Price");
		grid.add(priceCostL, 0, 3);

		TextField priceCosTF = new TextField();
		grid.add(priceCosTF, 1, 3);

		Label maxL = new Label("Max");
		grid.add(maxL, 0, 4);

		// hBox
		HBox hBoxForMaxMin = createHBox(3, 3);
		TextField maxTF = new TextField();
		maxTF.setMaxWidth(80);

		Label minL = new Label("            Min");
		hBoxForMaxMin.setAlignment(Pos.CENTER_LEFT);
		hBoxForMaxMin.getChildren().addAll(maxTF, minL);
		grid.add(hBoxForMaxMin, 1, 4);

		TextField minTF = new TextField();
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
		Button searchButton = new Button("Search");
		TextField searchTF = new TextField();
		topTableHB.getChildren().addAll(searchButton, searchTF);
		HBox topTable = createHBox(10, 10);
		TableView<Part> tableParts = createTable();//new TableView<>();

		topTable.getChildren().add(tableParts);
		HBox hBoxForButton = createHBox(5, 5);
		hBoxForButton.setAlignment(Pos.CENTER_RIGHT);
		Button btnAdd1 = new Button("Add");
		hBoxForButton.getChildren().add(btnAdd1);
		topVB.getChildren().addAll(topTableHB, topTable, hBoxForButton);
		//ending creating center top hBox for top table.
		
		// creating center bottom hBox for bottom table.
		VBox bottomVB = new VBox();
		
		HBox bottomTableHB = createHBox(10, 10);
		Label bottomSearchLabel = new Label("Search");
		TextField bottomSearchTF = new TextField();
		bottomTableHB.getChildren().addAll(bottomSearchLabel, bottomSearchTF);
		HBox bottomTable = createHBox(10, 10);
		TableView bottomTableProduct = createTable();
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
		Scene scene = new Scene(mainHB, 920, 510);
		this.setScene(scene);
		this.centerOnScreen();
		this.show();
	}

	private TableView<Part> createTable() {
		TableView<Part> table = new TableView<>();
		table.setMinWidth(430);
		TableColumn partId = new TableColumn("Part id");
		partId.setMaxWidth(100);
		TableColumn partName= new TableColumn("Part name");
		partName.setMaxWidth(100);
		TableColumn inventoryLevel = new TableColumn("Inventory level");
		inventoryLevel.setMinWidth(150);
		TableColumn priceCost = new TableColumn("Price per Unit");
		priceCost.setMinWidth(150);
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