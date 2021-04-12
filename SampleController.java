package application;

import java.awt.TextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;

public class SampleController {

    @FXML
    Button btn1;
    Button btn2;

    @FXML
    void handlebtn1() throws Exception {
      	Parent root = FXMLLoader.load(getClass().getResource("dd.fxml"));
    	Stage window = (Stage) btn1.getScene().getWindow(); 	
    	window.setScene(new Scene(root, 850, 500));
    }
    
    @FXML
    void handlebtn2() throws Exception {
      	Parent root = FXMLLoader.load(getClass().getResource("Sample1.fxml"));
    	Stage window = (Stage) btn2.getScene().getWindow(); 	
    	window.setScene(new Scene(root, 850, 500));
    }  


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
	void add(ActionEvent event) {
		clearChecked();
	}

	void clearChecked() {
		// habit.getEditor().clear();
		sun.setSelected(false);
		mon.setSelected(false);
		tue.setSelected(false);
		wed.setSelected(false);
		thu.setSelected(false);
		fri.setSelected(false);
		sat.setSelected(false);

	}

}
