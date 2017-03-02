package gui;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.dao.FabDao;
import com.faberlic.Goods;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AddDialogFX extends Stage {

	Map<String, TextField> mapTextFields = new HashMap<>();

	private FabDao fabDAO;
	private FaberlicGoods faberlicGoods;
	private User user;
	
	private Goods previosGoods = null;
	private boolean updateMode = false;

	public AddDialogFX(FaberlicGoods theFaberlicGoods, FabDao theFabDao, 
			Goods thePreviosGoods, boolean theUpdateMode, User user){
		this();
		fabDAO = theFabDao;
		faberlicGoods = theFaberlicGoods;
		previosGoods = thePreviosGoods;
		updateMode = theUpdateMode;
		if(updateMode){
			setTitle("Update goods");
			populateGUI(previosGoods);
		}
		this.user = user; 
	}

	public AddDialogFX() {

		String[] names = Goods.getNamesGoods();

		BorderPane layout = new BorderPane();/* layout */

		VBox vBoxTF = new VBox();
		vBoxTF.setPadding(new Insets(3, 3, 3, 3));
		vBoxTF.setSpacing(3);
		//vBoxTF.setAlignment(Pos.TOP_LEFT);
		for(int i = 0; i < names.length; i++){
			HBox hBox1 = new HBox();
			hBox1.setPadding(new Insets(3, 3, 3, 3));
			hBox1.setSpacing(3);
			hBox1.setAlignment(Pos.CENTER_LEFT);
			hBox1.getChildren().add(new Label(names[i]));

			mapTextFields.put(names[i], new TextField());

			HBox hBox2 = new HBox();
			hBox2.setPadding(new Insets(3, 3, 3, 3));
			hBox2.setSpacing(3);
			hBox2.setAlignment(Pos.CENTER_RIGHT);
			hBox2.getChildren().add(mapTextFields.get(names[i]));

			HBox mainBox = new HBox();
			mainBox.prefWidth(1000);
			HBox.setHgrow(hBox1, Priority.ALWAYS);
			mainBox.getChildren().addAll(hBox1, hBox2);

			vBoxTF.getChildren().addAll(mainBox);
		}

		Button btnSave = new Button("Save");
		Button btnCancel = new Button("Cancel");
		HBox hBoxForButton = new HBox();
		hBoxForButton.setSpacing(10);
		hBoxForButton.setPadding(new Insets(3, 3, 3, 3));
		hBoxForButton.getChildren().addAll(btnSave, btnCancel);
		hBoxForButton.setAlignment(Pos.CENTER);

		btnSave.setOnAction(e -> saveOrUpdateGoods());
		btnCancel.setOnAction(e ->{
			this.getScene().getWindow().hide();
			close();
		});
		
		layout.setCenter(vBoxTF);
		layout.setBottom(hBoxForButton);

		Scene scene = new Scene(layout, 300, 500);
		this.setScene(scene);
		this.setTitle("Add goods");
		this.centerOnScreen();
	}

	private void saveOrUpdateGoods() {
		if(updateMode){
			createConfirmAlert(createGoods(mapTextFields), "Updating goods", 
					"Are you sure you want update goods?");
		} else {
		createConfirmAlert(createGoods(mapTextFields), "Adding goods", 
				"Are you sure you wand add goods?");
		}
	}

	private Goods createGoods(Map<String, TextField> map) {
		Goods tempGoods = new Goods();
		try{
			tempGoods.setDiscount(map.get("discount").getText());
			tempGoods.setPage(map.get("page").getText());
			tempGoods.setArticle(map.get("article").getText());
			tempGoods.setName(map.get("name").getText());

			tempGoods.setPriceCatalog(new BigDecimal(map.get("price catalog").getText()));
			tempGoods.setTheSame(new BigDecimal(map.get("the same").getText()));
			tempGoods.setAllowance(map.get("allowance").getText());
			tempGoods.setPriceStore(new BigDecimal(map.get("price store").getText()));
			tempGoods.setBallConsultant(Float.valueOf(map.get("ball consultant").getText()));
			tempGoods.setPriceBuyer(new BigDecimal(map.get("price buyer").getText()));
			tempGoods.setBallBuyer(Float.parseFloat(map.get("ball buyer").getText()));
		} catch (NumberFormatException e){
			AlertGui.createAlertError(e);
		}
		return tempGoods;
	}
	
	private void populateGUI(Goods previosGoods2) {
		mapTextFields.get("discount").setText(previosGoods2.getDiscount());
		mapTextFields.get("page").setText(previosGoods2.getPage());
		mapTextFields.get("article").setText(previosGoods2.getArticle());
		mapTextFields.get("name").setText(previosGoods2.getName());
		mapTextFields.get("price catalog").setText(previosGoods2.getPriceCatalog().toString());
		mapTextFields.get("the same").setText(previosGoods2.getTheSame().toString());
		mapTextFields.get("allowance").setText(previosGoods2.getAllowance());
		mapTextFields.get("price store").setText(previosGoods2.getPriceStore().toString());
		mapTextFields.get("ball consultant").setText(Float.toString(previosGoods2.getBallConsultant()));
		mapTextFields.get("price buyer").setText(previosGoods2.getPriceBuyer().toString());
		mapTextFields.get("ball buyer").setText(Float.toString(previosGoods2.getBallBuyer()));
	}
	
	private void createConfirmAlert(Goods tempGoods, String title, String content){
		try {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle(title);
			alert.setContentText(content);
			Optional<ButtonType> result = alert.showAndWait();
			if ((result.isPresent()) && (result.get() == ButtonType.OK)) {
				if(updateMode){
					fabDAO.updateGoods(tempGoods, faberlicGoods.selectedId, user);
				} else {
					fabDAO.addGoods(tempGoods, user);
				}
				this.getScene().getWindow().hide();
				close();
				faberlicGoods.refreshFaberlicGoods();
			} else {
				this.getScene().getWindow().hide();
				close();
			}
		} catch (Exception e){
			AlertGui.createAlertError(e);
		}
	}
	
//	void badMethod() throws SQLException{
//		int size = 0;
//		if(size == 0){
//			throw new SQLException();
//		}
//	}

}