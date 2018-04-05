/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.automation.gui;

import attendance.automation.be.Person;
import attendance.automation.bll.StudentsManager;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;

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
     */
    Person loginCheck(String password, String username)throws Exception
    {
        return studentManager.loginCheck(password, username);
        
    }
    
    public void setDate(JFXDatePicker dateStud, JFXRadioButton radioButtonAbsent, JFXRadioButton radioButtonPresent)
    {
        studentManager.setDate(dateStud, radioButtonPresent, radioButtonAbsent);
    }

    

}
