/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.automation.gui;

import attendance.automation.be.Students;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
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
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
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
public class CorrectWindowController implements Initializable
{

    @FXML
    private JFXButton btnTeachSave;
    @FXML
    private JFXRadioButton radioTeachAbsent;
    @FXML
    private ToggleGroup correctGroup;
    @FXML
    private JFXRadioButton radioTeachPresent;
    @FXML
    private TableView<Students> tableCorrectOverview;
    @FXML
    private TableView<Students> tableCorrectCourse;
    @FXML
    private TableColumn<Students, String> clmnAllAttendance;
    @FXML
    private TableColumn<Students, String> clmnAllName;
    @FXML
    private TableColumn<?, ?> clmnStudenAttendance;
    @FXML
    private TableColumn<?, ?> clmnAttendanceDate;
    @FXML
    private JFXButton btnTeachGraph;
    @FXML
    private JFXButton btnTeachLogout;
    @FXML
    private JFXDatePicker dateFrom;
    @FXML
    private JFXDatePicker dateTo;

    private Model model = new Model();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        clmnAllName.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
        clmnAllAttendance.setCellValueFactory(new PropertyValueFactory<>("Overall"));

// Old code delete        
//        tableCorrectOverview.setItems(model.getStudents());
//        model.loadStudents();
    }

    @FXML
    private void teachSaveAction(ActionEvent event)
    {
        //TODO
    }

    public void loadStudentsCorrect()
    {
        model.loadStudents();
    }

    @FXML
    private void teachGraphAction(ActionEvent event)
    {
        Stage stage = new Stage();
        PieChart pieChart = new PieChart();

        PieChart.Data slice1 = new PieChart.Data("Johny", 25);
        PieChart.Data slice2 = new PieChart.Data("Bob", 10);
        PieChart.Data slice3 = new PieChart.Data("Emma", 15);
        PieChart.Data slice4 = new PieChart.Data("Morten", 50);
        PieChart.Data slice5 = new PieChart.Data("Frede", 50);
        PieChart.Data slice6 = new PieChart.Data("Palle", 23);
        PieChart.Data slice7 = new PieChart.Data("Tirben", 46);
        PieChart.Data slice8 = new PieChart.Data("Tina", 45);
        PieChart.Data slice9 = new PieChart.Data("Karsten", 7);
        PieChart.Data slice10 = new PieChart.Data("Åge", 21);
        PieChart.Data slice11 = new PieChart.Data("Ole", 65);

        pieChart.getData().add(slice1);
        pieChart.getData().add(slice2);
        pieChart.getData().add(slice3);
        pieChart.getData().add(slice4);
        pieChart.getData().add(slice5);
        pieChart.getData().add(slice6);
        pieChart.getData().add(slice7);
        pieChart.getData().add(slice8);
        pieChart.getData().add(slice9);
        pieChart.getData().add(slice10);
        pieChart.getData().add(slice11);

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
    }

    @FXML
    private void teachLogoutAction(ActionEvent event)
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
            Stage stageClose = (Stage) btnTeachLogout.getScene().getWindow();
            stageClose.close();
        } else
        {
            // ... user chose CANCEL or closed the dialog
        }
    }

}
