/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.automation;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * hej jeh
 *
 * @author Frederik Bærbar
 */
public class AttendanceAutomation extends Application
{

    private Stage primaryStage;
    private AnchorPane rootLayout; //BorderPane

    @Override
    public void start(Stage primaryStage)
    {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Attendance Automation");

        initRootLayout();

//        showChartOverview();
    }

    public void initRootLayout()
    {
        try
        {

            Parent root = FXMLLoader.load(getClass().getResource("gui/LoginWindow.fxml"));
            primaryStage.setTitle("Attendance Automation");
            primaryStage.setScene(new Scene(root, 273, 300));
            primaryStage.setResizable(false);
            primaryStage.show();
            
//            // Load root layout from fxml file.
//            FXMLLoader loader = new FXMLLoader();
//            loader.setLocation(AttendanceAutomation.class.getResource("gui/LoginWindow.fxml"));///address/   //RootPrototype
//            rootLayout = (AnchorPane) loader.load();  //BorderPane
//
////            ... controller = loader.getController();
////            controller.setRoot
//            // Show the scene containing the root layout.
//            Scene scene = new Scene(rootLayout);
//            primaryStage.setScene(new Scene(root, 750, 601));
//            primaryStage.resizableProperty();
//            primaryStage.show();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

//    public void showChartOverview()
//    {
//        try
//        {
//            // Load person overview.
//            FXMLLoader loader = new FXMLLoader();
//            loader.setLocation(AttendanceAutomation.class.getResource("gui/ChartView.fxml"));
//            BorderPane chartOverview = (BorderPane) loader.load();
//
//            // Set person overview into the center of root layout.
//            rootLayout.setCenter(chartOverview);
//
//            // Give the controller access to the main app.
//            ChartViewController controller = loader.getController();
//            controller.setMainApp(this);
//
//        } catch (IOException e)
//        {
//            e.printStackTrace();
//        }
//    }
    public Stage getPrimaryStage()
    {
        return primaryStage;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        launch(args);
    }

}
