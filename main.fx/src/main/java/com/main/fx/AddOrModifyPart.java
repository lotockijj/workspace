package com.main.fx;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class AddOrModifyPart extends Stage{
	TextField idTF, nameTF, invTF, priceCosTF, maxTF, minTF, compNameOrMachIdTF;
	RadioButton rbInHouse,  rbOutSourced;
	Label compNmOrMachIdL;
	MainScreen mainScreen;
	

	public AddOrModifyPart(MainScreen mainScreen, Part selectedPart, String title) {
		this.mainScreen = mainScreen;
		BorderPane layout = new BorderPane();
		//Create notice "Inventory Management System" and position it. 
		Label headName = new Label(title);
		headName.setFont(Font.font("Default", FontWeight.BOLD, 18));

		rbInHouse = new RadioButton("In-house");
		rbOutSourced = new RadioButton("Outsourced");
		final ToggleGroup group = new ToggleGroup();
		rbInHouse.setToggleGroup(group);
		rbOutSourced.setToggleGroup(group);
		rbOutSourced.setSelected(true);
		group.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
			public void changed(ObservableValue<? extends Toggle> ov,
					Toggle old_toggle, Toggle new_toggle) {
				if(group.getSelectedToggle() == rbInHouse){
					compNmOrMachIdL.setText("Machine ID       ");
				}
				if(group.getSelectedToggle() == rbOutSourced){
					compNmOrMachIdL.setText("Company name");
				}
			}                
		});

		HBox hBox = createHBox(15, 15);
		hBox.setAlignment(Pos.BASELINE_LEFT);
		hBox.getChildren().addAll(headName, rbInHouse, rbOutSourced);

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

		Label priceCostL = new Label("Price/Cost            ");
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

		compNmOrMachIdL = new Label("Company name");
		grid.add(compNmOrMachIdL, 0, 5);
		compNameOrMachIdTF = new TextField();
		grid.add(compNameOrMachIdTF, 1, 5);

		//create HBox for save and cancel button
		HBox hBoxSaveCancel = createHBox(20, 20);
		hBoxSaveCancel.setAlignment(Pos.BASELINE_RIGHT);
		Button btnSave = new Button("Save");
		Button btnCancel = new Button("Cancel");
		hBoxSaveCancel.getChildren().addAll(btnSave, btnCancel);
		layout.setTop(hBox);
		layout.setCenter(grid);
		layout.setBottom(hBoxSaveCancel);
		Scene scene = new Scene(layout, 450, 370);
		this.setScene(scene);
		this.centerOnScreen();
		this.show();

		btnCancel.setOnAction(e -> this.close());
		btnSave.setOnAction(e ->{
			if(group.getSelectedToggle() == rbInHouse){
				Inhouse part = new Inhouse();
				part.setPartID(mainScreen.selectedId + 1);
				part.setName(nameTF.getText());
				part.setInstock(Integer.parseInt(invTF.getText()));
				part.setPrice(Double.parseDouble(priceCosTF.getText()));
				part.setMax(Integer.parseInt(maxTF.getText()));
				part.setMin(Integer.parseInt(minTF.getText()));
				part.setMachineId(Integer.parseInt(compNameOrMachIdTF.getText()));
				if(title.equals("Modify part  ")){
					mainScreen.parts.set(mainScreen.selectedId, part);
				} else{
					mainScreen.parts.add(part);
				}
			}
			if(group.getSelectedToggle() == rbOutSourced){
				Outsourced part = new Outsourced();
				part.setPartID(mainScreen.selectedId + 1);
				part.setName(nameTF.getText());
				part.setInstock(Integer.parseInt(invTF.getText()));
				part.setPrice(Double.parseDouble(priceCosTF.getText()));
				part.setMax(Integer.parseInt(maxTF.getText()));
				part.setMin(Integer.parseInt(minTF.getText()));
				part.setCompanyName(compNameOrMachIdTF.getText());
				if(title.equals("Modify part  ")){
					mainScreen.parts.set(mainScreen.selectedId, part);
				} else{
					mainScreen.parts.add(part);
				}
			}
			mainScreen.refreshTables();
			this.close();
		});
		if(title.equals("Modify part  ")){
			populateModifyPart(selectedPart);
		}
	}

	private void populateModifyPart(Part selectedPart) {
		idTF.setText(Integer.toString(mainScreen.selectedId + 1));
		nameTF.setText(selectedPart.getName());
		invTF.setText(Integer.toString(selectedPart.getInstock()));
		priceCosTF.setText(Double.toString(selectedPart.getPrice()));
		maxTF.setText(Integer.toString(selectedPart.getMax()));
		minTF.setText(Integer.toString(selectedPart.getMin()));
		if (selectedPart instanceof Inhouse) {
			Inhouse tempPart = (Inhouse) selectedPart;
			compNameOrMachIdTF.setText(Integer.toString(tempPart.getMachineId()));
			rbInHouse.setSelected(true);
		}
		if(selectedPart instanceof Outsourced){
			Outsourced tempPart = (Outsourced) selectedPart;
			compNameOrMachIdTF.setText(tempPart.getCompanyName());
			rbOutSourced.setSelected(true);
		}
	}

	private HBox createHBox(int pad, int spac) {
		HBox hBox = new HBox();
		hBox.setPadding(new Insets(pad, pad, pad, pad));
		hBox.setSpacing(spac);
		return hBox;
	}

}
