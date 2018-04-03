/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.automation.gui.toDelete;

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
public class AttendanceOverviewController implements Initializable
{

    @FXML
    private JFXComboBox<?> comboClassOverviewCourses;
    @FXML
    private BarChart<?, ?> graphClassOverview;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        
    }    
    
}
