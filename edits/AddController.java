package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class AddController {

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
    	boolean [] week = new boolean [6];
     	if(sun.isSelected()) {
    		week[0] = true;
    	}
     	else if(mon.isSelected()) {
    		week[1] = true;
    	}
     	else if(tue.isSelected()) {
    		week[2] = true;
    	}
     	else if(wed.isSelected()) {
    		week[3] = true;
    	}
     	else if(thu.isSelected()) {
    		week[4] = true;
    	}
     	else if(fri.isSelected()) {
    		week[5] = true;
    	}
     	else {
    		week[6] = true;
    	}
     	//***push to DB
     	TaskManager push = new TaskManager("adding");
     	push.addFromGUIToDB(getHabit, week);
     	clear();
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
