package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class editController implements Initializable{
	
	//DB here
	TaskManager tm = new TaskManager("tm");
	
	int index = -1;

    @FXML
    private TableView<Habit> table;

    @FXML
    private TableColumn<Habit, String> habitColumn;

    @FXML
    private TableColumn<Habit, String> daysColumn;

    public void initialize(URL url, ResourceBundle rb) {
    	//set columns
    	habitColumn.setCellValueFactory(new PropertyValueFactory<Habit, String>("habit"));
        daysColumn.setCellValueFactory(new PropertyValueFactory<Habit, String>("goal"));
        
        //load dummy data
        table.setItems(getHabits());
    }
    
    public ObservableList<Habit> getHabits()
    {
    	ObservableList<Habit> result = FXCollections.observableArrayList(tm.getHabits());
    	return result;
    }
    
    @FXML
    private TextField habitE;
    
    @FXML
    //if a habit is clicked, it will retrieve the data associated with it
    void getSelected(MouseEvent event) {
    	
    	clear();
    	
    	Habit select = table.getSelectionModel().selectedItemProperty().get();
    		
    	if(select.getDays()[0] == true) {
    		sunE.setSelected(true);
    	}
    	if(select.getDays()[1] == true) {
    		monE.setSelected(true);
    	}
    	if(select.getDays()[2] == true) {
    		tueE.setSelected(true);
    	}
    	if(select.getDays()[3] == true) {
    		wedE.setSelected(true);
    	}
    	if(select.getDays()[4] == true) {
    		thuE.setSelected(true);
    	}
    	if(select.getDays()[5] == true) {
    		friE.setSelected(true);
    	}
    	if(select.getDays()[6] == true) {
    		satE.setSelected(true);
    	}
    	
    	index = table.getSelectionModel().getSelectedIndex();
    	
    	if(index <= -1) {
    		return;
    	}
    	else {
    		habitE.setText(habitColumn.getCellData(index).toString());
    	}
    }

    @FXML
    private CheckBox sunE;

    @FXML
    private CheckBox monE;

    @FXML
    private CheckBox tueE;

    @FXML
    private CheckBox wedE;

    @FXML
    private CheckBox thuE;

    @FXML
    private CheckBox friE;

    @FXML
    private CheckBox satE;
    
    @FXML
    void sendToEdit(ActionEvent event) {
       	String getHabit = habitE.getText();
    	boolean [] week = new boolean [7];
    	
    	int count = 0;
    	
     	if(sunE.isSelected()) {
    		week[0] = true;
    		count++;
    	}
     	if(monE.isSelected()) {
    		week[1] = true;
    		count++;
    	}
     	if(tueE.isSelected()) {
    		week[2] = true;
    		count++;
    	}
     	if(wedE.isSelected()) {
    		week[3] = true;
    		count++;
    	}
     	if(thuE.isSelected()) {
    		week[4] = true;
    		count++;
    	}
     	if(friE.isSelected()) {
    		week[5] = true;
    		count++;
    	}
     	if(satE.isSelected()){
    		week[6] = true;
    		count++;
    	}
     	
     	//***edit habit in DB
     	Habit allocate = table.getSelectionModel().selectedItemProperty().get();

     	tm.updateHabit(allocate, getHabit);
     	tm.updateDays(allocate, week);
     	tm.updateGoal(allocate, count);
    }
    
    private void clear() {
    	//clears text-fields
		habitE.clear();
		
		//clears check-boxes
		sunE.setSelected(false);
		monE.setSelected(false);
		tueE.setSelected(false);
		wedE.setSelected(false);
		thuE.setSelected(false);
		friE.setSelected(false);
		satE.setSelected(false);	
	}
    
}
