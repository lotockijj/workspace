package com.main.fx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class MainScreen extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
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
		
		TableView tableParts = new TableView();
		TableColumn partId = new TableColumn("Part id");
		TableColumn partName= new TableColumn("Part name");
		TableColumn inventoryLevel = new TableColumn("Inventory level");
		TableColumn priceCost = new TableColumn("Price/Cost" + "\n" + "per Unit");
		
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
		TableView tableProducts = new TableView();
		TableColumn productId = new TableColumn("Product id");
		TableColumn productName= new TableColumn("Product name");
		TableColumn inventoryLevelPr = new TableColumn("Inventory level");
		TableColumn priceCostPr = new TableColumn("Price/Cost" + "\n" + "per Unit");
		
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
		btnAddPart.setOnAction(e -> new AddOrModifyPart("Add part   "));
		btnModifyPart.setOnAction(e -> new AddOrModifyPart("Modify part  "));
		btnAddPr.setOnAction(e -> new AddOrModifyProduct("Add Product"));
		btnModifyPr.setOnAction(e -> new AddOrModifyProduct("Modify Product"));
		//btnModify
	}

	private HBox createHBox(int pad, int spac) {
		HBox hBox = new HBox();
		hBox.setPadding(new Insets(pad, pad, pad, pad));
		hBox.setSpacing(spac);
		return hBox;
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	


}