/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.automation.bll;

import attendance.automation.be.Students;
import attendance.automation.be.Teachers;
import attendance.automation.dal.AttendanceDAO;
import attendance.automation.gui.CorrectWindowController;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;
import java.util.List;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;

/**
 *
 * @author Jens Karlskov
 */
public class StudentsManager
{

    AttendanceDAO attendanceDAO = new AttendanceDAO();

    /**
     * En liste af alle employees i databasen
     *
     * @return
     */
    public List<Students> getAllStudents()
    {
        return attendanceDAO.getAllStudents();
    }

    public List<Teachers> getAllTeachers()
    {
        return attendanceDAO.getAllTeachers();
    }

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
     */
    public void loginCheck(String password, String email, CorrectWindowController cwc, Parent root1, FXMLLoader fxmlLoader, Parent root2, FXMLLoader fxmlLoader2, JFXButton loginBtn, Label lblErrorLoginS, Label lblErrorLoginT)
    {
        attendanceDAO.getAllLogins(password, email, cwc, root1, fxmlLoader, root2, fxmlLoader2, loginBtn, lblErrorLoginS, lblErrorLoginT);
    }

    public void setDate(JFXDatePicker dateStud,JFXRadioButton radioButtonAbsent, JFXRadioButton radioButtonPresent)
    {
        attendanceDAO.addAttendance(dateStud, radioButtonAbsent, radioButtonPresent);
    }
}
