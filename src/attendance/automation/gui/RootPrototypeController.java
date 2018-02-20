/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.automation.gui;

import attendance.automation.AttendanceAutomation;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

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
    private ImageView imgLogo;

    private Stage primaryStage;

//    private AttendanceAutomation mainApp;
    @FXML
    private BorderPane borderRoot;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {

//        Image image = new Image("file:logo.png");
//        imgLogo.setImage(image);
    }

    public RootPrototypeController()
    {

    }

    @FXML
    private void attendanceAction(ActionEvent event)
    {
        try
        {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(AttendanceAutomation.class.getResource("gui/ChartView.fxml"));
            BorderPane chartOverview = (BorderPane) loader.load();

            // Set person overview into the center of root layout.
            borderRoot.setCenter(chartOverview);

            // Give the controller access to the main app.
            ChartViewController controller = loader.getController();
//            controller.setMainApp(mainApp);

        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    @FXML
    private void overviewAction(ActionEvent event)
    {
        try
        {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(AttendanceAutomation.class.getResource("gui/AttendanceOverview.fxml"));
            BorderPane chartOverview = (BorderPane) loader.load();

            // Set person overview into the center of root layout.
            borderRoot.setCenter(chartOverview);

            // Give the controller access to the main app.
            ChartViewController controller = loader.getController();
//            controller.setMainApp(mainApp);

        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    @FXML
    private void correctAction(ActionEvent event)
    {

        try
        {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(AttendanceAutomation.class.getResource("gui/CorrectWindow.fxml"));
            BorderPane chartOverview = (BorderPane) loader.load();

            // Set person overview into the center of root layout.
            borderRoot.setCenter(chartOverview);

            // Give the controller access to the main app.
            ChartViewController controller = loader.getController();
//            controller.setMainApp(mainApp);

        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    @FXML
    private void studentAction(ActionEvent event)
    {
        try
        {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(AttendanceAutomation.class.getResource("gui/AttendeesView.fxml"));
            AnchorPane chartOverview = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            borderRoot.setCenter(chartOverview);

            // Give the controller access to the main app.
//            ChartViewController controller = loader.getController();
//            controller.setMainApp(mainApp);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    @FXML
    private void teacherAction(ActionEvent event)
    {

    }

}
