package application;

import java.awt.Button;
import java.awt.TextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;

public class SampleController2 {

    @FXML
    private TextField goal;

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
    private Button confirm;

    @FXML
    void add(ActionEvent event) {

    	sun.setSelected(false);
    	mon.setSelected(false);
    	tue.setSelected(false);
    	wed.setSelected(false);
    	thu.setSelected(false);
    	fri.setSelected(false);
    	sat.setSelected(false);
    }

}
