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
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Pair;

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
        // Create the custom dialog.
        Dialog<Pair<String, String>> dialog = new Dialog<>();
        dialog.setTitle("Teacher Login");
        dialog.setHeaderText(" ");

// Set the icon (must be included in the project).
        dialog.setGraphic(new ImageView(this.getClass().getResource("Images/logo2.PNG").toString()));
// Set the button types.
        ButtonType loginButtonType = new ButtonType("Login", ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);

// Create the username and password labels and fields.
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        TextField username = new TextField();
        username.setPromptText("Username");
        PasswordField password = new PasswordField();
        password.setPromptText("Password");

        grid.add(new Label("Username:"), 0, 0);
        grid.add(username, 1, 0);
        grid.add(new Label("Password:"), 0, 1);
        grid.add(password, 1, 1);

// Enable/Disable login button depending on whether a username was entered.
        Node loginButton = dialog.getDialogPane().lookupButton(loginButtonType);
        loginButton.setDisable(true);

// Do some validation (using the Java 8 lambda syntax).
        username.textProperty().addListener((observable, oldValue, newValue) ->
        {
            loginButton.setDisable(newValue.trim().isEmpty());
        });

        dialog.getDialogPane().setContent(grid);

// Request focus on the username field by default.
        Platform.runLater(() -> username.requestFocus());

// Convert the result to a username-password-pair when the login button is clicked.
        dialog.setResultConverter(dialogButton ->
        {
            if (dialogButton == loginButtonType)
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
                return new Pair<>(username.getText(), password.getText());
            }
            return null;
        });

        Optional<Pair<String, String>> result = dialog.showAndWait();

        result.ifPresent(usernamePassword ->
        {
            System.out.println("Username=" + usernamePassword.getKey() + ", Password=" + usernamePassword.getValue());
        });

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
