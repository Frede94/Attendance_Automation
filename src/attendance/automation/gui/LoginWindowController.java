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
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author morte
 */
public class LoginWindowController implements Initializable
{

    @FXML
    private JFXTextField usernameLbl;
    @FXML
    private JFXTextField passwordLbl;
    @FXML
    private JFXCheckBox rememberPassword;
    @FXML
    private JFXButton loginBtn;
    @FXML
    private JFXButton cancelBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        
      
        
    }
        

    
    
    
    @FXML
    private void pressLoginBtn(ActionEvent event)
    {
            
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("RootPrototype.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            RootPrototypeController ewc = fxmlLoader.getController();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.setTitle("Attendance Window");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
      
        
    }

    @FXML
    private void pressCancelBtn(ActionEvent event)
    {
    }
    
}
