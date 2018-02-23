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
 * @author Frederik Bærbar
 */
public class TeacherViewController implements Initializable
{

    @FXML
    private TableView<?> tableTeachersTeachers;
    @FXML
    private TableColumn<?, ?> tableTeachersClmnFirstName;
    @FXML
    private TableColumn<?, ?> tableTeachersClmnLastName;
    @FXML
    private TableColumn<?, ?> tableTeachersClmnCity;
    @FXML
    private TableColumn<?, ?> tableClmnCountry;
    @FXML
    private TableColumn<?, ?> tableTeachersClmnEmail;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
    }    
    
}
