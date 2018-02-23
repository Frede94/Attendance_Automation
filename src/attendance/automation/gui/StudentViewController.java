/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.automation.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author morte
 */
public class StudentViewController implements Initializable
{

    @FXML
    private TableView<?> tableAttendees;
    @FXML
    private TableColumn<?, ?> tableClmnFirstName;
    @FXML
    private TableColumn<?, ?> tableClmnLastName;
    @FXML
    private TableColumn<?, ?> tableClmnCity;
    @FXML
    private TableColumn<?, ?> tableClmnCountry;
    @FXML
    private TableColumn<?, ?> tableClmnEmail;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        
    }    
    
}
