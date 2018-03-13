/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.automation.gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXRadioButton;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Frederik
 */
public class SubmitController implements Initializable
{

    @FXML
    private JFXDatePicker dateStud;
    @FXML
    private JFXButton btnStudSave;
    @FXML
    private ToggleGroup submitGroup;
    @FXML
    private JFXRadioButton radioStudPresent;
    @FXML
    private JFXListView<?> listSubmit;
    @FXML
    private JFXButton btnStudGraph;
    @FXML
    private JFXButton btnStudLogout;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
    }
    /**
     * submits the students attendance on the current day.
     * (on the day chosen, is automaticly set to current day)
     * @param event 
     */
    @FXML
    private void studSaveAction(ActionEvent event)
    {
        // TODO
    }
    /**
     * Opens new window where a chart where the student can view his/her
     * attendance in a chart.
     * @param event 
     */
    @FXML
    private void studGraphAction(ActionEvent event)
    {
        makePieChart();

//        try
//            {
//                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AttendanceOverview.fxml"));
//                Parent root1 = (Parent) fxmlLoader.load();
//                AttendanceOverviewController aoc = fxmlLoader.getController();
//                Stage stage = new Stage();
//                stage.setScene(new Scene(root1));
//                stage.setTitle("Login");
//                stage.initModality(Modality.APPLICATION_MODAL);
//                stage.show();
//
//            } catch (Exception e)
//            {
//                e.printStackTrace();
//            }
    }

    /**
     * Sets data in a piechart window, and show the attendance percentage when
     * mouse is over the slice you wont to check
     */
    public void makePieChart()
    {
        Stage stage = new Stage();
        PieChart pieChart = new PieChart();

        PieChart.Data slice1 = new PieChart.Data("DBOS", 25);
        PieChart.Data slice2 = new PieChart.Data("SCO", 10);
        PieChart.Data slice3 = new PieChart.Data("SDE", 15);
        PieChart.Data slice4 = new PieChart.Data("ITO", 50);

        pieChart.getData().add(slice1);
        pieChart.getData().add(slice2);
        pieChart.getData().add(slice3);
        pieChart.getData().add(slice4);

        pieChart.setPrefSize(700, 600);

        pieChart.setLegendSide(Side.LEFT);
        pieChart.setStartAngle(30);

        final Label caption = new Label("");
        caption.setTextFill(Color.WHITE);
        caption.setStyle("-fx-font: 12 arial;");

        for (final PieChart.Data data : pieChart.getData())
        {
            data.getNode().addEventHandler(MouseEvent.MOUSE_ENTERED_TARGET, new EventHandler<MouseEvent>()
            {
                @Override
                public void handle(MouseEvent e)
                {
                    caption.setTranslateX(e.getSceneX());
                    caption.setTranslateY(e.getSceneY());

                    caption.setText(String.valueOf(data.getPieValue()));
                }
            });
        }

        stage.setTitle("Attendance");
        AnchorPane root = new AnchorPane();
        root.getChildren().addAll(pieChart, caption);

        Scene scene = new Scene(root, 700, 600);

        stage.setScene(scene);

        stage.show();
//        Stage stage = new Stage();
//        Scene scene = new Scene(new Group());
//        stage.setTitle("Attendance");
//        stage.initModality(Modality.APPLICATION_MODAL);
//        stage.setWidth(500);
//        stage.setHeight(500);
//
//        ObservableList<PieChart.Data> pieChartData
//                = FXCollections.observableArrayList(
//                        new PieChart.Data("DBOS", 25),
//                        new PieChart.Data("SCO", 25),
//                        new PieChart.Data("SDE", 25),
//                        new PieChart.Data("ITO", 25));
//        final PieChart chart = new PieChart(pieChartData);
//        chart.setTitle("Attendance");
//
//        ((Group) scene.getRoot()).getChildren().add(chart);
//        stage.setScene(scene);
//        stage.show();
//
//        final Label caption = new Label("");
//        caption.setTextFill(Color.DARKORANGE);
//        caption.setStyle("-fx-font: 24 arial;");
//
//        for (final PieChart.Data data : chart.getData())
//        {
//            data.getNode().addEventHandler(MouseEvent.MOUSE_PRESSED,
//                    new EventHandler<MouseEvent>()
//            {
//                @Override
//                public void handle(MouseEvent e)
//                {
//                    caption.setTranslateX(e.getSceneX() + 5);
//                    caption.setTranslateY(e.getSceneY() + 5);
//                    caption.setText(String.valueOf(data.getPieValue()) + "%");
//                }
//            });
//        }
    }
    /**
     * logs the student out of the program and brings them back
     * to the login window, where they can choose to log in again
     * or close the program.
     * @param event 
     */
    @FXML
    private void studLogoutAction(ActionEvent event
    )
    {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Log out");
        alert.setHeaderText("Log Out");
        alert.setContentText("Are you sure you want to log out");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK)
        {
            try
            {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LoginWindow.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                LoginWindowController ewc = fxmlLoader.getController();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage.setTitle("Login");
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.show();

            } catch (Exception e)
            {
                e.printStackTrace();
            }
            Stage stageClose = (Stage) btnStudLogout.getScene().getWindow();
            stageClose.close();
        } else
        {
            // ... user chose CANCEL or closed the dialog
        }
    }

}
