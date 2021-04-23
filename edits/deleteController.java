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
import javafx.scene.control.cell.PropertyValueFactory;

public class deleteController implements Initializable{

    @FXML
    private TableView<Habit> table;

    @FXML
    private TableColumn<Habit, String> habitColumn;

    @FXML
    private TableColumn<Habit, String> daysColumn;

    public void initialize(URL url, ResourceBundle rb) {
    	habitColumn.setCellValueFactory(new PropertyValueFactory<Habit, String>("habit"));
        daysColumn.setCellValueFactory(new PropertyValueFactory<Habit, String>("days"));
    	//*****FIX THIS ^^^^
    	//*****NEED a method to convert daysofweek back to a string of days
        
        //load dummy data
        table.setItems(getHabit());
        //*****table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }
    
    public ObservableList<Habit> getHabit()
    {
    	//TaskManager x = new TaskManager("delete");
    	//ObservableList<Habit> y = (ObservableList<Habit>) x.getHabits();
    	//ObservableList<Habit> z = FXCollections.observableArrayList(x.getHabits());
    	
    	
    	//------------------------------------------------------------------------------------
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
    public void deleteHabit() {
    	ObservableList<Habit> selectedRows, allHabits;
        allHabits = table.getItems();
        
        //this gives us the rows that were selected
        selectedRows = table.getSelectionModel().getSelectedItems();
        
        //loop over the selected rows and remove the Person objects from the table
        //selectedRows.forEach(allHabits::remove);
        for (Habit h: selectedRows) //ERROR
        {
        	if(allHabits.size() >= 1){
        			allHabits.remove(h);
        			//*****delete from db
        	}
        }
    }
    
}
