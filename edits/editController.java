package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class editController implements Initializable{
	
	int index = -1;

    @FXML
    private TableView<Habit> table;

    @FXML
    private TableColumn<Habit, String> habitColumn;

    @FXML
    private TableColumn<Habit, String> daysColumn;

    public void initialize(URL url, ResourceBundle rb) {
    	habitColumn.setCellValueFactory(new PropertyValueFactory<Habit, String>("habit"));
        daysColumn.setCellValueFactory(new PropertyValueFactory<Habit, String>("days")); //use dow chnager to pass 
    	//*****FIX THIS ^^^^
    	//*****NEED a method to convert daysofweek back to a string of days
        
        //load dummy data
        table.setItems(getHabit());
        //*****table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }
    
    public ObservableList<Habit> getHabit()
    {
    	//*****pull from DB
        ObservableList<Habit> habits = FXCollections.observableArrayList();
        
        int[] defaultGoal = {0, 0 ,0 ,0 ,0 ,0 ,0}; 
        boolean [] g = {true, false, true, false, false, false, false};
        boolean [] ho = {true, false, true, false, true, true, false};
        
		Habit h = new Habit("eat more", 2, g, defaultGoal);
		Habit hi = new Habit("go to the gym", 4, ho, defaultGoal);
		
        habits.add(h);
        habits.add(hi);
        
        return habits;
    }
    
    @FXML
    private TextField habitE;
    
    @FXML
    void getSelected(MouseEvent event) {
    	index = table.getSelectionModel().getSelectedIndex();
    	if(index <= -1) {
    		return;
    	}
    	habitE.setText(habitColumn.getCellData(index).toString());
    	//add checkbox
    	//whatever is true from dOW, then set selected true on edit page
    	//get habit -> get dow for it -> iterate and find checkboxes that are tue;
    	  //checkboxname.setSelected(true);
    }
    
}
