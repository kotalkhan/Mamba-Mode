package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TaskManager {

    @FXML
    Button btn1;
    Button btn2;

    @FXML
    /*
     * Handles the transition from the home page to the add screen
     */
    void handlebtn1() throws Exception {
      	Parent root = FXMLLoader.load(getClass().getResource("dd.fxml"));
    	Stage window = (Stage) btn1.getScene().getWindow(); 	
    	window.setScene(new Scene(root, 850, 500));
    }
    
    @FXML
    /*
     * Handles the transition from the add screen to the home page
     */
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
	/*
	 * Adds data from the GUI to the database
	 */
	void add(ActionEvent event) {	
		String goal = habit.getText();
		//add goal to habit
	  
		if(sun.isSelected()) {
			//add in whatever position
		}
		if(mon.isSelected()) {
			//add in whatever position
		}
		if(tue.isSelected()) {
			//add in whatever position
		}
		if(wed.isSelected()) {
			//add in whatever position
		}
		if(thu.isSelected()) {
			//add in whatever position
		}
		if(fri.isSelected()) {
			//add in whatever position
		}
		if(sat.isSelected()) {
			//add in whatever position
		}
		if(sun.isSelected()) {
			//add in whatever position
		}
		
		clearChecked();
	}

	/*
	 * Clears all checkboxes after confirm button is chosen
	 */
	void clearChecked() {
		sun.setSelected(false);
		mon.setSelected(false);
		tue.setSelected(false);
		wed.setSelected(false);
		thu.setSelected(false);
		fri.setSelected(false);
		sat.setSelected(false);

	}

}
