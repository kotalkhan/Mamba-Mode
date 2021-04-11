package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.stage.Stage;

public class SampleController {

    @FXML
    private ComboBox mainMenu;

    @FXML
    private Label label;
    
    ObservableEvent <String> dropDown = FXCollections.observableArrayList("Habits", "Statistics", "Calendar", "Goals");
    mainMenu.setItems(list);
    
    @FXML
    void select(ActionEvent event) {
    	String s = mainMenu.getSelectionModel().getSelectedItem().toString();
    	label.setText(s);
    }
    
    @FXML
    private void mainChoice() {
    	if(mainMenu.getValue().equals("Habits")) {
    		handleHabit();
    	}
    }
    
    public void handleHabit() {
    	GridPane root = (GridPane)FXMLLoader.load(getClass().getResource("Sample2.fxml"));
    	Scene scene = new Scene(root,850,500);
    	primaryStage.setScene(scene);
		primaryStage.show();
    }