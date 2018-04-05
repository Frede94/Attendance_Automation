/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.automation.gui;

import attendance.automation.be.Person;
import attendance.automation.be.User;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
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
    private JFXPasswordField txtPassword;

    private AAModel aaModel = new AAModel();

    private SubmitController sCtrl = new SubmitController();
    @FXML
    private Label lblErrorLoginS;
    @FXML
    private Label lblErrorLoginT;

    private Person person;

    private User user;

    private User username;

    private User password;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {

    }

    /**
     * Logs the user in based on what userlogin they user if it is a teacher,
     * the program goes to the teacher window, or if it is a students it opens
     * the studentview.
     */
    @FXML
    private void pressLoginBtn()
    {

//        try
//        {
        String password = txtPassword.getText();
        String username = txtUsername.getText();

        try
        {
            Person loggedInPerson = aaModel.loginCheck(password, username);

            if(loggedInPerson.isIsTeacher())
            {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CorrectWindow.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                CorrectWindowController cwc = fxmlLoader.getController();
                lblErrorLoginS.setText("");
                lblErrorLoginT.setText("");
                System.out.println("Teacher login succes");
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage.setTitle("Attendance Window");
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.show();
                Stage stageClose = (Stage) loginBtn.getScene().getWindow();
                stageClose.close();
            }else            
            {
                FXMLLoader fxmlLoader2 = new FXMLLoader(getClass().getResource("Submit.fxml"));
                Parent root2 = (Parent) fxmlLoader2.load();
                SubmitController sc = fxmlLoader2.getController();
                lblErrorLoginS.setText("");
                lblErrorLoginT.setText("");
                System.out.println("Student login succes");
                Stage stage = new Stage();
                stage.setScene(new Scene(root2));
                stage.setTitle("Attendance Window");
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.show();
                Stage stageClose = (Stage) loginBtn.getScene().getWindow();
                stageClose.close();
            }
        

        } catch (Exception ex)
        {
            lblErrorLoginS.setText("Student login not correct!");
            System.out.println("Student login failed");
            lblErrorLoginT.setText("Teacher login not correct!");
            System.out.println("Teacher login failed");
            
            System.out.println("Fejl!!: "+ex);
        }
    }

    /**
     * closes the program
     *
     * @param event
     */
    @FXML
    private void pressCancelBtn(ActionEvent event)
    {
        Stage stage = (Stage) cancelBtn.getScene().getWindow();
        stage.close();
    }

    /**
     * logs the user in, using the method pressLoginBtn.
     *
     * @param event
     */
    @FXML
    private void pressEnterLoginBtn(KeyEvent event)
    {
        pressLoginBtn();
    }

    public void welcomeTxt()
    {
        String password = txtPassword.getText();
        String email = txtUsername.getText();

        sCtrl.welcomeTxt(txtUsername);
    }

}
