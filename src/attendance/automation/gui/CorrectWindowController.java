/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.automation.gui;

import attendance.automation.be.Students;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextArea;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;

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
    private JFXButton btnTeachSave;
    @FXML
    private JFXRadioButton radioTeachAbsent;
    @FXML
    private ToggleGroup correctGroup;
    @FXML
    private JFXRadioButton radioTeachPresent;
    @FXML
    private TableView<Students> tableCorrectOverview;
    @FXML
    private TableView<Students> tableCorrectCourse;
    @FXML
    private TableColumn<Students, String> clmnAllAttendance;
    @FXML
    private TableColumn<Students, String> clmnAllName;
    @FXML
    private TableColumn<?, ?> clmnStudentCourse;
    @FXML
    private TableColumn<?, ?> clmnStudenAttendance;

    private Model model = new Model();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        clmnAllName.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
        clmnAllAttendance.setCellValueFactory(new PropertyValueFactory<>("Overall"));
        
        tableCorrectOverview.setItems(model.getStudents());
        model.loadStudents();
    }    

    @FXML
    private void teachSaveAction(ActionEvent event)
    {
        
    }
    
    public void loadStudentsCorrect()
    {
        model.loadStudents();
    }
    
}
