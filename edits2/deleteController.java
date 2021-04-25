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
	
	//DB here
	TaskManager tm = new TaskManager("tm");
	
    @FXML
    private TableView<Habit> table;

    @FXML
    private TableColumn<Habit, String> habitColumn;

    @FXML
    private TableColumn<Habit, String> daysColumn;

    public void initialize(URL url, ResourceBundle rb) {
    	habitColumn.setCellValueFactory(new PropertyValueFactory<Habit, String>("habit"));
        daysColumn.setCellValueFactory(new PropertyValueFactory<Habit, String>("days"));
        
        //load dummy data
        table.setItems(getHabits());
    }
    
    public ObservableList<Habit> getHabits()
    {
    	ObservableList<Habit> result = FXCollections.observableArrayList(tm.getHabits());
    	return result;
    }
    
    @FXML
    public void sendToDelete() {
    	ObservableList<Habit> selectedRows; 
    	ObservableList<Habit> allHabits;
        
    	//this gives us all the rows 
    	allHabits = table.getItems();
        
        //this gives us all the rows that were selected
        selectedRows = table.getSelectionModel().getSelectedItems();
        
        for(Habit h: selectedRows)
        {
        	if(allHabits.size() >= 1) {
        		allHabits.remove(h);
        		//***delete habit from the DB
        		tm.deleteHabit(h);
        	}
        }
    }
    
}