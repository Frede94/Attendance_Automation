/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.automation.gui;

import attendance.automation.bll.StudentsManager;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

/**
 *
 * @author Frederik Bærbar
 */
public class AAModel
{
    
    private StudentsManager studentManager = new StudentsManager();

    void login(String password, String email)
    {
        studentManager.login(password, email);
    }

    void loginCheck(String password, String email, CorrectWindowController cwc, Parent root1, FXMLLoader fxmlLoader)
    {
        studentManager.loginCheck(password, email, cwc, root1, fxmlLoader);
    }
    
}
