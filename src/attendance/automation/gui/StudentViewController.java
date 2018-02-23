/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.automation.gui;

import attendance.automation.be.Students;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author morte
 */
public class StudentViewController implements Initializable
{

    @FXML
    private TableView<Students> tableAttendees;
    @FXML
    private TableColumn<Students, String> tableClmnFirstName;
    @FXML
    private TableColumn<Students, String> tableClmnLastName;
    @FXML
    private TableColumn<Students, String> tableClmnCity;
    @FXML
    private TableColumn<Students, String> tableClmnCountry;
    @FXML
    private TableColumn<Students, String> tableClmnEmail;

    private Model Model = new Model();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        tableClmnFirstName.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
        tableClmnLastName.setCellValueFactory(new PropertyValueFactory<>("LastName"));
        tableClmnCity.setCellValueFactory(new PropertyValueFactory<>("City"));
        tableClmnCountry.setCellValueFactory(new PropertyValueFactory<>("Country"));
        tableClmnEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
        
        tableAttendees.setItems(Model.getStudents());
        Model.loadStudents();
    }    
    
    void loadStudent()
    {
        Model.loadStudents();
    }
    
    
}
