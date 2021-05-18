package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.ResourceBundle;
import java.util.TimeZone;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class viewController implements Initializable{
	
	//DB here
	TaskManager tm = new TaskManager("tm");
	
	@FXML
    private TableView<Habit> tb;

    @FXML
    private TableColumn<Habit, String> hab;
    
    //checks for the current day
	Calendar cal = Calendar.getInstance(TimeZone.getDefault());
	int todayDay = cal.get(Calendar.DAY_OF_WEEK) - 1;
    
    public ObservableList<Habit> getNewHabits()
    {   
        ArrayList<Habit> dayHabits = new ArrayList<Habit>();
        
        //checks if the day is contained in each habit
        for(Habit h : tm.getHabits()) {
        	if(h.getDays()[todayDay] == true) {
        		dayHabits.add(h);
        	}
        }
        
    	ObservableList<Habit> result = FXCollections.observableArrayList(dayHabits);
    	return result;
    }
	    
    public void initialize(URL url, ResourceBundle rb) {
     	//set columns
		hab.setCellValueFactory(new PropertyValueFactory<Habit, String>("habit"));
		tb.setItems(getNewHabits());
    }
    
    @FXML
    void updateStats(MouseEvent event) {
    	Habit h = tb.getSelectionModel().selectedItemProperty().get();
    	int [] days = new int [7];
    	
    	if(h == null) return;
    	
    	//all values initially set to zero
    	days[todayDay] = 1;
    	tm.updateStatus(h, days);
    }
    
}