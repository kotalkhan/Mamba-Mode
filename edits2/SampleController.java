package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class SampleController implements Initializable{
	
	//DB here
	TaskManager tm = new TaskManager("tm");

    @FXML
    private Button btn1;

    @FXML
    private Button btn2;

    @FXML
    public void home2habits() throws Exception {
    	Parent root = FXMLLoader.load(getClass().getResource("Sample3.fxml"));
    	Stage window = (Stage) btn2.getScene().getWindow();
    	window.setScene(new Scene(root, 850, 550));
    }

    @FXML
    public void home2statistics() throws Exception {
    	Parent root = FXMLLoader.load(getClass().getResource("Sample2.fxml"));
    	Stage window = (Stage) btn1.getScene().getWindow();
    	window.setScene(new Scene(root, 850, 550));
    }

    @FXML
    private Button btn3;

    @FXML
    private Button btn4;

    @FXML
    public void statistics2habits() throws Exception {
    	Parent root = FXMLLoader.load(getClass().getResource("Sample3.fxml"));
    	Stage window = (Stage) btn4.getScene().getWindow();
    	window.setScene(new Scene(root, 850, 550));
    }

    @FXML
    public void statistics2home() throws Exception {
    	Parent root = FXMLLoader.load(getClass().getResource("Sample.fxml"));
    	Stage window = (Stage) btn3.getScene().getWindow();
    	window.setScene(new Scene(root, 850, 550));
    }
    
    @FXML
    private Button btn5;

    @FXML
    private Button btn6;

    @FXML
    public void habits2home() throws Exception {
    	Parent root = FXMLLoader.load(getClass().getResource("Sample.fxml"));
    	Stage window = (Stage) btn5.getScene().getWindow();
    	window.setScene(new Scene(root, 850, 550));
    }

    @FXML
    public void habits2statistics() throws Exception {
    	Parent root = FXMLLoader.load(getClass().getResource("Sample2.fxml"));
    	Stage window = (Stage) btn6.getScene().getWindow();
    	window.setScene(new Scene(root, 850, 550));
    }
    
    @FXML
    private Button addy;
    
    @FXML
    void addHabit(ActionEvent event) {	
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("add.fxml"));
	    	Parent root = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
	    	stage.setScene(new Scene(root));
	    	
	    	stage.initModality(Modality.WINDOW_MODAL);
	    	stage.initOwner(addy.getScene().getWindow());
	    	stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		} 	
    }
    
    @FXML
    private Button edity;
    
    @FXML
    void editHabit(ActionEvent event) {	
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("edit.fxml"));
	    	Parent root = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
	    	stage.setScene(new Scene(root));
	    	
	    	stage.initModality(Modality.WINDOW_MODAL);
	    	stage.initOwner(edity.getScene().getWindow());
	    	stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		} 	
    }
    
    @FXML
    private Button deletey;
    
    @FXML
    void deleteHabit(ActionEvent event) {	
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("delete.fxml"));
	    	Parent root = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
	    	stage.setScene(new Scene(root));
	    	
	    	stage.initModality(Modality.WINDOW_MODAL);
	    	stage.initOwner(deletey.getScene().getWindow());
	    	stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		} 	
    }
    
    @FXML
    private TableView<Habit> tb;
    
    @FXML
    private TableColumn<Habit, String> mo;

    @FXML
    private TableColumn<Habit, String> tu;

    @FXML
    private TableColumn<Habit, String> we;

    @FXML
    private TableColumn<Habit, String> th;

    @FXML
    private TableColumn<Habit, String> fr;

    @FXML
    private TableColumn<Habit, String> sa;
    
    public ObservableList<Habit> getHabits()
    {
    	ObservableList<Habit> result = FXCollections.observableArrayList(tm.getHabits());
    	return result;
    }
    
    public void initialize(URL url, ResourceBundle rb) {
    	//set columns
    	mo.setCellValueFactory(new PropertyValueFactory<Habit, String>("habit"));
        //daysColumn.setCellValueFactory(new PropertyValueFactory<Habit, String>("days"));
        
        //load dummy data
        tb.setItems(getHabits());
    }
}
