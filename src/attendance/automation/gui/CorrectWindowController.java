/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.automation.gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextArea;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author Frederik
 */
public class CorrectWindowController implements Initializable
{

    @FXML
    private JFXDatePicker dateTeach;
    @FXML
    private JFXTextArea commentTeach;
    @FXML
    private TableView<?> tableCorrectAttendance;
    @FXML
    private JFXButton btnTeachSave;
    @FXML
    private JFXRadioButton radioTeachAbsent;
    @FXML
    private ToggleGroup correctGroup;
    @FXML
    private JFXRadioButton radioTeachPresent;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
    }    
    
}