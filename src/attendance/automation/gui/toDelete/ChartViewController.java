/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.automation.gui.toDelete;

import attendance.automation.AttendanceAutomation;
import com.jfoenix.controls.JFXComboBox;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;

/**
 * FXML Controller class
 *
 * @author Frederik Bærbar
 */
public class ChartViewController implements Initializable
{
    private AttendanceAutomation mainApp;
    @FXML
    private JFXComboBox<?> comboYourAttendance;
    @FXML
    private BarChart<?, ?> graphYourAttendanceOverview;

    public ChartViewController()
    {
        
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
    }

//    public void setMainApp(AttendanceAutomation mainApp)
//    {
//        this.mainApp = mainApp;
//
//        // Add observable list data to the table
//        //personTable.setItems(mainApp.getPersonData());
//    }

}