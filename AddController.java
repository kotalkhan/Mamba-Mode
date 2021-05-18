package application;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class AddController {
	
	//DB here
	TaskManager tm = new TaskManager("tm");

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
    void sendToAdd(ActionEvent event) {
    	String getHabit = habit.getText();
    	boolean [] week = new boolean [7];
    	
     	if(sun.isSelected()) {
    		week[0] = true;
    	}
     	if(mon.isSelected()) {
    		week[1] = true;
    	}
     	if(tue.isSelected()) {
    		week[2] = true;
    	}
     	if(wed.isSelected()) {
    		week[3] = true;
    	}
     	if(thu.isSelected()) {
    		week[4] = true;
    	}
     	if(fri.isSelected()) {
    		week[5] = true;
    	}
     	if(sat.isSelected()){
    		week[6] = true;
    	}
     	
     	//if no days are selected
     	if(!sun.isSelected() && !mon.isSelected() && !tue.isSelected() && !wed.isSelected() 
     			&& !thu.isSelected() && !fri.isSelected() && !sat.isSelected()) {
     		infoBox1("Please choose at least one day", "Alert");
     	}
     	//if at least one day is selected
     	if(sun.isSelected() || mon.isSelected() || tue.isSelected() || wed.isSelected() 
     			|| thu.isSelected() || fri.isSelected() || sat.isSelected()) {
	     	//***push habit to DB  	
	     	tm.addFromGUIToDB(getHabit, week);
	     	clear();
     	}
    }
    
    public static void infoBox1(String infoMessage, String titleBar)
    {
        infoBox2(infoMessage, titleBar, null);
    }

    public static void infoBox2(String infoMessage, String titleBar, String headerMessage)
    {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(titleBar);
        alert.setHeaderText(headerMessage);
        alert.setContentText(infoMessage);
        alert.showAndWait();
    }

	private void clear() {
		habit.clear();
		sun.setSelected(false);
		mon.setSelected(false);
		tue.setSelected(false);
		wed.setSelected(false);
		thu.setSelected(false);
		fri.setSelected(false);
		sat.setSelected(false);
	}
    
}
