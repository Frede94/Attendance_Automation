/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.automation.gui;

import attendance.automation.bll.StudentsManager;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;

/**
 *
 * @author Frederik Bærbar
 */
public class AAModel
{
    private StudentsManager studentManager = new StudentsManager();

    /**
     * Will log in a user based on what he/she types in as login information
     * program check the database for the info, to see if it is a registert user
     * if it is, then the program wil log in to the correct windows.
     * @param password
     * @param email
     * @param cwc
     * @param root1
     * @param fxmlLoader
     * @param root2
     * @param fxmlLoader2
     * @param loginBtn
     * @param lblErrorLoginS
     * @param lblErrorLoginT 
     */
    void loginCheck(String password, String email, CorrectWindowController cwc, Parent root1, FXMLLoader fxmlLoader, Parent root2, FXMLLoader fxmlLoader2, JFXButton loginBtn, Label lblErrorLoginS, Label lblErrorLoginT)
    {
        studentManager.loginCheck(password, email, cwc, root1, fxmlLoader, root2, fxmlLoader2, loginBtn, lblErrorLoginS, lblErrorLoginT);
    }
    
    public void setDate(JFXDatePicker dateStud)
    {
        studentManager.setDate(dateStud);
    }

}
