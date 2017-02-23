package helpful;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableColumn;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.List;
import java.util.ArrayList;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
 
public class FxTableViewExample1 extends Application {
 
    private TableView table;
    private ObservableList data;
    private Text actionStatus;
 
    public static void main(String [] args) {
        Application.launch(args);
    }
 
    @Override
    public void start(Stage primaryStage) {
 
        primaryStage.setTitle("Table View Example 1");
        // Books label
        Label label = new Label("Books");
        label.setTextFill(Color.DARKBLUE);
        label.setFont(Font.font("Calibri", FontWeight.BOLD, 36));
        HBox hb = new HBox();
        hb.setAlignment(Pos.CENTER);
        hb.getChildren().add(label);
 
        // Table view, data, columns and properties
 
        table = new TableView();
        data = getInitialTableData();
        table.setItems(data);
 
        TableColumn titleCol = new TableColumn("Title");
        titleCol.setCellValueFactory(new PropertyValueFactory("title"));
        TableColumn authorCol = new TableColumn("Author");
        authorCol.setCellValueFactory(new PropertyValueFactory("author"));
 
        table.getColumns().setAll(titleCol, authorCol);
        table.setPrefWidth(450);
        table.setPrefHeight(300);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
 
        table.getSelectionModel().selectedIndexProperty().addListener(
                new RowSelectChangeListener());
         
        // Status message text
        actionStatus = new Text();
        actionStatus.setFill(Color.FIREBRICK);
 
        // Vbox
        VBox vbox = new VBox(20);
        vbox.setPadding(new Insets(25, 25, 25, 25));;
        vbox.getChildren().addAll(hb, table, actionStatus);
 
        // Scene
        Scene scene = new Scene(vbox, 500, 475); // w x h
        primaryStage.setScene(scene);
        primaryStage.show();
 
        // Select the first row
        table.getSelectionModel().select(0);
        Book book = table.getSelectionModel().getSelectedItem();
        actionStatus.setText(book.toString());
 
    } // start()
 
    private class RowSelectChangeListener implements ChangeListener {
 
        @Override
        public void changed(ObservableValue ov, Number oldVal, Number newVal) {
 
            int ix = newVal.intValue();
 
            if ((ix = data.size())) {
     
                return; // invalid data
            }
 
            Book book = data.get(ix);
            actionStatus.setText(book.toString()); 
        }
    }
 
    private ObservableList getInitialTableData() {
 
        List list = new ArrayList();
        list.add(new Book("The Thief", "Fuminori Nakamura"));
        list.add(new Book("Of Human Bondage", "Somerset Maugham"));
        list.add(new Book("The Bluest Eye", "Toni Morrison"));
        list.add(new Book("I Am Ok You Are Ok", "Thomas Harris"));
        list.add(new Book("Magnificent Obsession", "Lloyd C Douglas"));
        list.add(new Book("100 Years of Solitude", "Gabriel Garcia Marquez"));
        list.add(new Book("What the Dog Saw", "Malcolm Gladwell"));
        list.add(new Book("The Fakir", "Ruzbeh Bharucha"));
        list.add(new Book("The Hobbit", "J.R.R. Tolkien"));
        list.add(new Book("Strange Life of Ivan Osokin", "P.D. Ouspensky"));
        list.add(new Book("The Hunt for Red October", "Tom Clancy"));
        list.add(new Book("Coma", "Robin Cook"));
 
        ObservableList data = FXCollections.observableList(list);
 
        return data;
    }
}