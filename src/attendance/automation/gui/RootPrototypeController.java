/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.automation.gui;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
/**
 * FXML Controller class
 *
 * @author Frederik Bærbar
 */
public class RootPrototypeController implements Initializable
{

    @FXML
    private JFXButton btnAttendance;
    @FXML
    private JFXButton btnOverview;
    @FXML
    private JFXButton btnCorrectAttendance;
    @FXML
    private ImageView imgView;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
    }

    @FXML
    private void attendanceAction(ActionEvent event)
    {
        Image image = new Image("file:/C:/Users/Frederik%20Bærbar/Desktop/SCO/Attendance%20Automation/src/attendance/automation/gui/Images/ChartView.PNG");
        imgView.setImage(image);
    }

    @FXML
    private void overviewAction(ActionEvent event)
    {
        Image image = new Image("file:/C:/Users/Frederik%20Bærbar/Desktop/SCO/Attendance%20Automation/src/attendance/automation/gui/Images/2018-2019-calendar.PNG");
        imgView.setImage(image);
    }

    @FXML
    private void correctAction(ActionEvent event)
    {
        Image image = new Image("file:/C:/Users/Frederik%20Bærbar/Desktop/SCO/Attendance%20Automation/src/attendance/automation/gui/Images/blank.PNG");
        imgView.setImage(image);
    }

}
