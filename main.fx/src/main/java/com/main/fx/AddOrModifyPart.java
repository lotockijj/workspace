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
	TextField idTF;
	Label compNmOrMachIdL;

	public AddOrModifyPart(String title) {
		BorderPane layout = new BorderPane();
		//Create notice "Inventory Management System" and position it. 
		Label headName = new Label(title);
		headName.setFont(Font.font("Default", FontWeight.BOLD, 18));

		RadioButton rbInHouse = new RadioButton("In-house");
		RadioButton rbOutSourced = new RadioButton("Outsourced");
		final ToggleGroup group = new ToggleGroup();
		rbInHouse.setToggleGroup(group);
		rbOutSourced.setToggleGroup(group);
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
		rbOutSourced.setSelected(true);

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

		TextField nameTF = new TextField();
		grid.add(nameTF, 1, 1);

		Label inv = new Label("Inv");
		grid.add(inv, 0, 2);

		TextField invTF = new TextField();
		grid.add(invTF, 1, 2);

		Label priceCostL = new Label("Price/Cost            ");
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

		compNmOrMachIdL = new Label("Company name");
		grid.add(compNmOrMachIdL, 0, 5);
		TextField compNameTF = new TextField();
		grid.add(compNameTF, 1, 5);

		//create HBox for save and cancel button
		HBox hBoxSaveCancel = createHBox(20, 20);
		hBoxSaveCancel.setAlignment(Pos.BASELINE_RIGHT);
		Button btnSave = new Button("Save");
		Button btnCansel = new Button("Cansel");
		hBoxSaveCancel.getChildren().addAll(btnSave, btnCansel);
		layout.setTop(hBox);
		layout.setCenter(grid);
		layout.setBottom(hBoxSaveCancel);
		Scene scene = new Scene(layout, 450, 370);
		this.setScene(scene);
		this.centerOnScreen();
		this.show();
	}

	private HBox createHBox(int pad, int spac) {
		HBox hBox = new HBox();
		hBox.setPadding(new Insets(pad, pad, pad, pad));
		hBox.setSpacing(spac);
		return hBox;
	}

}