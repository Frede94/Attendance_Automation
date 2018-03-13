/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.automation.gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author morte
 */
public class LoginWindowController implements Initializable
{

    private JFXTextField usernameLbl;
    @FXML
    private JFXCheckBox rememberPassword;
    @FXML
    private JFXButton loginBtn;
    @FXML
    private JFXButton cancelBtn;
    @FXML
    private JFXTextField txtUsername;
    @FXML
    private JFXTextField txtPassword;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {

    }

    @FXML
    private void pressLoginBtn()
    {

        try
        {
            if (txtUsername.getText().toLowerCase().contains("lærer"))
            {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CorrectWindow.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                CorrectWindowController cwc = fxmlLoader.getController();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage.setTitle("Attendance Window");
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.show();
                Stage stageClose = (Stage) loginBtn.getScene().getWindow();
                stageClose.close();
            } else if (txtUsername.getText().toLowerCase().contains("elev"))
            {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Submit.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                SubmitController sc = fxmlLoader.getController();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage.setTitle("Attendance Window");
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.show();
                Stage stageClose = (Stage) loginBtn.getScene().getWindow();
                stageClose.close();
            } else if (txtUsername.getText().toLowerCase().contains(""))
            {
                //DO NOTHING...
            }

        } catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    @FXML
    private void pressCancelBtn(ActionEvent event)
    {
        Stage stage = (Stage) cancelBtn.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void pressEnterLoginBtn(KeyEvent event)
    {
        pressLoginBtn();
    }

}
