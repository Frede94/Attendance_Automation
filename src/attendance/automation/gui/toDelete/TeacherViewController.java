/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.automation.gui.toDelete;

import attendance.automation.be.Teachers;
import attendance.automation.gui.Model;
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
 * @author Frederik Bærbar
 */
public class TeacherViewController implements Initializable
{

    @FXML
    private TableView<Teachers> tableTeachersTeachers;
    @FXML
    private TableColumn<Teachers, String> tableTeachersClmnFirstName;
    @FXML
    private TableColumn<Teachers, String> tableTeachersClmnLastName;
    @FXML
    private TableColumn<Teachers, String> tableTeachersClmnCity;
    @FXML
    private TableColumn<Teachers, String> tableClmnCountry;
    @FXML
    private TableColumn<Teachers, String> tableTeachersClmnEmail;

    private Model model = new Model();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        tableTeachersClmnFirstName.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
        tableTeachersClmnLastName.setCellValueFactory(new PropertyValueFactory<>("LastName"));
        tableTeachersClmnCity.setCellValueFactory(new PropertyValueFactory<>("City"));
        tableClmnCountry.setCellValueFactory(new PropertyValueFactory<>("Country"));
        tableTeachersClmnEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
        
        tableTeachersTeachers.setItems(model.getTeachers());
        loadTeachers();
    }

    public void loadTeachers()
    {
//        model.loadTeachers();
    }

}
