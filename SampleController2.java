package application;

import java.awt.Label;
import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class SampleController2 {

	private Stage stage;
	
    @FXML
    private ComboBox mainMenu;

    @FXML
    private TextField goal;

    @FXML
    private TextField habit;

    @FXML
    private CheckBox sun;

    @FXML
    private CheckBox mon;

    @FXML
    private CheckBox tue;

    @FXML
    private CheckBox wed;

    @FXML
    private CheckBox thu;

    @FXML
    private CheckBox fri;

    @FXML
    private CheckBox sat;

    @FXML
    private Button confirm;

    @FXML
    private Label label;

    @FXML
    //sends code to DataBase class to add to the database and clears values
    void add(ActionEvent event) {
    	clear();
	
    }

    @FXML
    //sets the drop down choices
    public void initialize() {
    	ObservableList <String> dropDown = FXCollections.observableArrayList("Home", "Statistics", "Calendar", "Goals");
        mainMenu.setItems(dropDown);
    }
    
    @FXML
    //selects the drop down option
    void select(ActionEvent event) throws IOException {
    	String s = mainMenu.getSelectionModel().getSelectedItem().toString();
    	//checks if habit is home to go back
    	if(s.equals("Home")) {
//    		Stage primary = new Stage();
//    		Parent root = FXMLLoader.load(getClass().getResource("Sample1.fxml"));
//    		primary.setScene(new Scene(root,850,500));
//    		primary.show();
    		Stage primaryStage = this.stage;
    		Parent pane = FXMLLoader.load(getClass().getResource("Sample1.fxml"));
    		primaryStage.getScene().setRoot(pane);
    	}
    }
    
    //clears all fields
    void clear() {
    	goal.clear();
    	habit.clear();
    	sun.setSelected(false);
    	mon.setSelected(false);
    	tue.setSelected(false);
    	wed.setSelected(false);
    	thu.setSelected(false);
    	fri.setSelected(false);
    	sat.setSelected(false);
    }
    
    //Goes back to the home screen
//    public void handleHome() {
//    	GridPane root = (GridPane)FXMLLoader.load(getClass().getResource("Sample2.fxml"));
//    	Scene scene = new Scene(root,850,500);
//    	Stage window = (Stage) mainChoice().getScene().getWindow();
//    	root.setScene(scene);
//		root.show();
//    }

}
