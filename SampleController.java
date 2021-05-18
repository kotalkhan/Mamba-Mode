package application;

import java.io.IOException;
import java.util.Calendar;
import java.util.TimeZone;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class SampleController{

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
    private Button viewy;
    
    @FXML
    void viewHabit(ActionEvent event) {	
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("view.fxml"));
	    	Parent root = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
	    	stage.setScene(new Scene(root));
	    	root.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
	    	
	    	stage.initModality(Modality.WINDOW_MODAL);
	    	stage.initOwner(deletey.getScene().getWindow());
	    	stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		} 	
    }
    
    @FXML private Label donelbl;
    
    @FXML private Label missedlbl;
    
    @FXML private Label totallbl;
    
	@FXML private Button GetDatabtn;
    
    @FXML
    public void displayData() 
    {
    	Statistics s  = new Statistics();
    	TaskManager t = new TaskManager("tm");
    	
    	int done = s.getNumberDone();
    	int missed = s.getMissed();    	
    	    	
    	donelbl.setText("Done: " + done);
    	missedlbl.setText("Missed: " + missed);
    	totallbl.setText("Total Habits: " + t.getHabits().size());   	
    }
    
}