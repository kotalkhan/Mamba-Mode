package application;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class SampleController {

    @FXML
    private ComboBox mainMenu;

    @FXML
    private Label label;
    
    private Stage stage;
    
    @FXML
    //sets the drop down choices
    public void initialize() {
    	ObservableList <String> dropDown = FXCollections.observableArrayList("Habits", "Statistics", "Calendar", "Goals");
        mainMenu.setItems(dropDown);
    }
    
    //selects the drop down option
    @FXML
    void select(ActionEvent event) throws IOException {
    	String s = mainMenu.getSelectionModel().getSelectedItem().toString();
    	//Parent root;
    	//FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
    	//checks if habit is home to go back
    	//root = (Parent)loader.load();
    	if(s.equals("Habits")) {
//    		FXMLLoader loader = new FXMLLoader();
//			loader.setLocation(Main.class.getResource("Sample2.fxml"));
//			Parent root = (Parent)loader.load();
//        	Scene scene = new Scene(root,850,500);
//        	Stage x = new Stage();
//        	x.setScene(scene);
//    		x.show();
    		
//    		Stage primary = new Stage();
//    		Parent root = FXMLLoader.load(getClass().getResource("Sample2.fxml"));
//    		primary.setScene(new Scene(root,850,500));
//    		primary.show();
//    		
//    		FXMLLoader loader = new FXMLLoader(getClass().getResource("Sample2.fxml"));
    		
    		Stage primaryStage = this.stage;
    		Parent pane = FXMLLoader.load(getClass().getResource("Sample2.fxml"));
    		primaryStage.getScene().setRoot(pane);
    		
    	}
    }
    
    //Goes to the add habit screen
    public void handleHabit() {
    	
    }
}