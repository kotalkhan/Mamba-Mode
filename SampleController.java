package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class SampleController {

    @FXML
    private ComboBox mainMenu;

    @FXML
    private Label label;
    
    @FXML
    public void initialize() {
    	ObservableList <String> dropDown = FXCollections.observableArrayList("Habits", "Statistics", "Calendar", "Goals");
        mainMenu.setItems(dropDown);
    }
    
    @FXML
    void select(ActionEvent event) {
    	String s = mainMenu.getSelectionModel().getSelectedItem().toString();
    	label.setText(s);
    }
    
//    @FXML
//    private void mainChoice() {
//    	if(mainMenu.getValue().equals("Habits")) {
//    		handleHabit();
//    	}
//    }
//    
//    public void handleHabit() {
//    	GridPane root = (GridPane)FXMLLoader.load(getClass().getResource("Sample2.fxml"));
//    	Scene scene = new Scene(root,850,500);
//    	Stage window = (Stage) mainChoice().getScene().getWindow();
//    	root.setScene(scene);
//		root.show();
//    }
}
