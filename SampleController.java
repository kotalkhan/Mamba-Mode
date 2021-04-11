package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.stage.Stage;


public class SampleController {
	
	private Stage stage; 
	private Scene scene;
	private Parent root;
	
	@FXML
	private MenuBar myMenuBar;
	
    @FXML
    void habits(ActionEvent event) throws IOException{
    	root = FXMLLoader.load(getClass().getResource("Sample2.fxml"));
    	scene = new Scene(root);
    	stage = (Stage) myMenuBar.getScene().getWindow(); 	
    	stage.setScene(scene);
    	stage.show();
    }
}


