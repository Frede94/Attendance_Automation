/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.automation.gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextArea;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author Frederik
 */
public class SubmitController implements Initializable
{

    @FXML
    private JFXDatePicker dateStud;
    @FXML
    private JFXTextArea commentStud;
    @FXML
    private JFXButton btnStudSave;
    @FXML
    private JFXRadioButton radioStudAbsent;
    @FXML
    private ToggleGroup submitGroup;
    @FXML
    private JFXRadioButton radioStudPresent;
    @FXML
    private JFXListView<?> listSubmit;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
    }    

    @FXML
    private void studSaveAction(ActionEvent event)
    {
    }
    
}
